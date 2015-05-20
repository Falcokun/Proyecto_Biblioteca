package pe.edu.ulima.servlet;

import pe.edu.ulima.bd.MongoInstance;
import pe.edu.ulima.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ricardo on 12/05/2015.
 * Arquitectura de Software
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login/Post");
        String user, password;
        user = request.getParameter("user");
        password = request.getParameter("password");
        System.out.println(user + "-" + password);

        Usuario usuario = MongoInstance.getInstance().login(user, password);

        if (usuario != null) {
            if (usuario.isAdmin()) {
                response.sendRedirect("./admin");
            } else {
                response.sendRedirect("./user");
            }
        } else {
            response.sendRedirect("./");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login/Get");
        response.sendRedirect("./");
    }
}
