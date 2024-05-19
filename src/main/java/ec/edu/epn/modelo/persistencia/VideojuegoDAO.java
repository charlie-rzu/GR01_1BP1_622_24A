package ec.edu.epn.modelo.persistencia;

import ec.edu.epn.modelo.entidad.Videojuego;
import ec.edu.epn.modelo.services.BaseDeDatos;

import java.util.List;

public class VideojuegoDAO {
    private String titulo;
    private String nombreDeDesarrollador;
    private double precio;

    public VideojuegoDAO(String titulo, String nombreDeDesarrollador, double precio) {
        this.titulo = titulo;
        this.nombreDeDesarrollador = nombreDeDesarrollador;
        this.precio = precio;
    }

    public VideojuegoDAO() {
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

    public Videojuego getVideojuegoByTitulo(String tituloDelVideojuego) {
        return (Videojuego) BaseDeDatos.obtenerVideojuegoPorTitulo(tituloDelVideojuego);
    }

    public List<Videojuego> getVideojuegosByRangoDePrecio(double precioMinimo, double precioMaximo) {
        return (List<Videojuego>) BaseDeDatos.obtenerVideojuegosPorRangoDePrecio(precioMinimo,precioMaximo);
    }
}
