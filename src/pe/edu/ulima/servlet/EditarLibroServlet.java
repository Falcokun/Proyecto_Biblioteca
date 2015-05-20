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
 * Editar Libro
 */
@WebServlet(name = "EditarLibroServlet", urlPatterns = {"/editarLibro"})
public class EditarLibroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String id = request.getParameter("idedit");
        String titulo = request.getParameter("tituloedit");
        String autor = request.getParameter("autoredit");
        String carrera = request.getParameter("carreraedit");
        String edicion = request.getParameter("edicionedit");
        int cantidad = Integer.parseInt(request.getParameter("cantidadedit"));
        boolean estado = Boolean.parseBoolean(request.getParameter("estadoedit"));
        String descripcion = request.getParameter("descripcionedit");

        Libro libro = new Libro(titulo, carrera, estado, cantidad, edicion, descripcion, autor);
        MongoInstance.getInstance().editarLibro(id,libro);

        List<Libro> libroList;
        libroList = MongoInstance.getInstance().getLibros();
        session.setAttribute("libros", libroList);
        response.sendRedirect("./admin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String id = request.getParameter("id");
        Libro libro = MongoInstance.getInstance().getLibro(id);
        session.setAttribute("libro", libro);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editar.jsp");
        dispatcher.forward(request, response);
    }
}
