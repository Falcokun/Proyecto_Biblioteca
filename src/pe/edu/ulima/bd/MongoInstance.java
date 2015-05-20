package pe.edu.ulima.bd;

import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import pe.edu.ulima.model.Libro;
import pe.edu.ulima.model.Usuario;

import java.util.List;

/**
 * Created by Ricardo on 12/05/2015.
 * Configuracion de Mongo
 */
public class MongoInstance {
    public static MongoInstance instance;
    MongoClient mongo;
    Datastore ds;
    Morphia morphia;


    private MongoInstance() {
        mongo = new MongoClient();
        morphia = new Morphia();
        morphia.map(Usuario.class);
        morphia.map(Libro.class);
        ds = morphia.createDatastore(mongo, "proy_arqui");
    }

    public static MongoInstance getInstance() {
        if (instance == null) {
            instance = new MongoInstance();
        }
        return instance;
    }

    public void createUser(Usuario usuario) {
        ds.save(usuario);

    }

    public Usuario login(String user, String password) {
        Query<Usuario> query = ds.createQuery(Usuario.class);
        query.field("username").equal(user);
        query.field("password").equal(password);
        return query.get();
    }

    public void createLibro(Libro libro) {
        ds.save(libro);
    }

    public List<Libro> getLibrosUsuarios() {
        Query<Libro> query = ds.createQuery(Libro.class);
        query.field("activo").equal(true);
        return query.asList();
    }

    public List<Libro> getLibros() {
        Query<Libro> query = ds.createQuery(Libro.class);
        return query.asList();
    }

    public void deleteLibro(String id) {
        Query<Libro> query = ds.createQuery(Libro.class);
        query.field("id").equal(new ObjectId(id));
        ds.findAndDelete(query);
    }

    public Libro getLibro(String id) {
        Query<Libro> query = ds.createQuery(Libro.class);
        query.field("id").equal(new ObjectId(id));
        query.limit(1);
        return query.get();
    }

    public void editarLibro(String id, Libro libro) {
        Query<Libro> query = ds.createQuery(Libro.class);
        query.field("id").equal(new ObjectId(id));
        UpdateOperations<Libro> ops = ds.createUpdateOperations(Libro.class);
        ops.set("titulo",libro.getTitulo());
        ops.set("autor",libro.getAutor());
        ops.set("carrera",libro.getCarrera());
        ops.set("edicion",libro.getEdicion());
        ops.set("descripcion",libro.getDescripcion());
        ds.findAndModify(query,ops);
    }
}

