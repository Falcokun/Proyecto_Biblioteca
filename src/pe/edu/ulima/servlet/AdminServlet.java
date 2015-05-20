package pe.edu.ulima.servlet;

import pe.edu.ulima.bd.MongoInstance;
import pe.edu.ulima.model.Libro;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ricardo on 14/05/2015.
 * Administrador
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/admin"})
public class AdminServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Libro> libroList;
        libroList = MongoInstance.getInstance().getLibros();
        session.setAttribute("libros", libroList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request,response);
        //response.sendRedirect("/admin.jsp");
    }
}
