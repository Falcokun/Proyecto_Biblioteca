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
 * Borrar Libro
 */
@WebServlet(name = "BorrarLibroServlet", urlPatterns = {"/borrarLibro"})
public class BorrarLibroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id = request.getParameter("id");

        MongoInstance.getInstance().deleteLibro(id);

        List<Libro> libroList = MongoInstance.getInstance().getLibros();
        session.setAttribute("libros", libroList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
