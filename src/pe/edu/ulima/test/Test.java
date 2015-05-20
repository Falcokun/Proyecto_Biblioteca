package pe.edu.ulima.test;

import pe.edu.ulima.bd.MongoInstance;
import pe.edu.ulima.model.Libro;
import pe.edu.ulima.model.Usuario;

import java.util.List;

/**
 * Created by Ricardo on 13/05/2015.
 * Tester
 */
public class Test {
    public static void main(String[] args) {
        MongoInstance.getInstance();
        //createUser();
        //login("admin", "admin");
        //createLibro();
        loadlibros();
    }

    private static void loadlibros() {
        List<Libro> libros = MongoInstance.getInstance().getLibrosUsuarios();
        System.out.println(libros);
    }

    private static void createLibro() {
        //String titulo, String carrera, boolean activo, int cantidad, String edicion, String descripcion, String autor
        Libro libro = new Libro("Los mejores Chistes", "Administración", true, 3, "2015", "Los Mejores Chistes", "Ion Fernandez");
        MongoInstance.getInstance().createLibro(libro);
    }


    private static void login(String username, String password) {
        System.out.println(MongoInstance.getInstance().login(username, password));
    }

    private static void createUser() {
        Usuario usuario = new Usuario("user", "user", false);
        MongoInstance.getInstance().createUser(usuario);
    }
}
