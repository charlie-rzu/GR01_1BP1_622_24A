package ec.edu.epn.modelo.entidad;

import jakarta.persistence.*;

@Entity
@Table
public class Videojuego {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idVideojuego;
    private String titulo;
    private String nombreDeDesarrollador;
    private double precio;



    public Videojuego(String titulo, String nombreDeDesarrollador, double precio) {
        this.titulo = titulo;
        this.nombreDeDesarrollador = nombreDeDesarrollador;
        this.precio = precio;
    }

    public Videojuego() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombreDeDesarrollador() {
        return nombreDeDesarrollador;
    }

    public void setNombreDeDesarrollador(String nombreDeDesarrollador) {
        this.nombreDeDesarrollador = nombreDeDesarrollador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + idVideojuego + '|' +
                " titulo: " + titulo + '|' +
                " dev: " + nombreDeDesarrollador + '|' +
                " precio: " + precio +
                '}';
    }

    public int getIdVideojuego() {
        return idVideojuego;
    }
}
