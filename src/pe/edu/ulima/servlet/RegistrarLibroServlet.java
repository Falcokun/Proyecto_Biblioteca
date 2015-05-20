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
 * Registrar Libro Servlet
 */
@WebServlet(name = "RegistrarLibroServlet", urlPatterns = {"/registrarLibro"})
public class RegistrarLibroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String carrera = request.getParameter("carrera");
        String edicion = request.getParameter("edicion");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        boolean estado = Boolean.parseBoolean(request.getParameter("estado"));
        String descripcion = request.getParameter("descripcion");

        Libro libro = new Libro(titulo, carrera, estado, cantidad, edicion, descripcion, autor);
        MongoInstance.getInstance().createLibro(libro);

        List<Libro> libroList;
        libroList = MongoInstance.getInstance().getLibros();
        session.setAttribute("libros", libroList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
