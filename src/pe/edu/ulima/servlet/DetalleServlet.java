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

/**
 * Created by Ricardo on 19/05/2015.
 * Detalle Servlet
 */
@WebServlet(name = "DetalleServlet")
public class DetalleServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        Libro libro = MongoInstance.getInstance().getLibro(id);
        session.setAttribute("libro", libro);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/detalle.jsp");
        dispatcher.forward(request, response);
    }
}
