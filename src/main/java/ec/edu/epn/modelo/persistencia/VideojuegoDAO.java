package ec.edu.epn.modelo.persistencia;

import ec.edu.epn.modelo.entidad.Videojuego;
import ec.edu.epn.modelo.services.BaseDeDatos;

import java.util.List;

public class VideojuegoDAO {
    private String titulo;
    private String nombreDeDesarrollador;
    private double precio;
    private BaseDeDatos baseDeDatos;

    public VideojuegoDAO(String titulo, String nombreDeDesarrollador, double precio) {
        this.titulo = titulo;
        this.nombreDeDesarrollador = nombreDeDesarrollador;
        this.precio = precio;
        this.baseDeDatos = new BaseDeDatos();
    }

    public VideojuegoDAO() {
        this.baseDeDatos = new BaseDeDatos();
    }

    public List<Videojuego> getVideojuegoByTitulo(String tituloDelVideojuego) {
        return baseDeDatos.obtenerVideojuegoPorTitulo(tituloDelVideojuego);
    }

    public List<Videojuego> getVideojuegoByDesarrollador(String nombreDesarrollador) {
        return baseDeDatos.obtenerVideojuegoPorDesarrollador(nombreDesarrollador);
    }

    public List<Videojuego> getVideojuegosByRangoDePrecio(double precioMinimo, double precioMaximo) {
        return baseDeDatos.obtenerVideojuegosPorRangoDePrecio(precioMinimo, precioMaximo);
    }
}
