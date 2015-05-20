package pe.edu.ulima.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by Ricardo on 13/05/2015.
 * Usuario
 */
@Entity("libro")
public class Libro {
    @Id
    ObjectId id;
    String titulo;
    String carrera;
    boolean activo;
    int cantidad;
    String edicion;
    String descripcion;
    String autor;

    public Libro() {
    }

    public Libro(String titulo, String carrera, boolean activo, int cantidad, String edicion, String descripcion, String autor) {
        this.titulo = titulo;
        this.carrera = carrera;
        this.activo = activo;
        this.cantidad = cantidad;
        this.edicion = edicion;
        this.descripcion = descripcion;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public ObjectId getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", carrera='" + carrera + '\'' +
                ", activo=" + activo +
                ", cantidad=" + cantidad +
                ", edicion='" + edicion + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
