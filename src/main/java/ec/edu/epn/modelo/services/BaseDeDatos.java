package ec.edu.epn.modelo.services;

import ec.edu.epn.modelo.entidad.Videojuego;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

public class BaseDeDatos implements Serializable {

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public BaseDeDatos() {
        emf = Persistence.createEntityManagerFactory("GR01_1BP1_622_24A_PU");
        this.emf = emf;
    }


    public void persistirObjeto(Object objetoAPersistirEnLaBD){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(objetoAPersistirEnLaBD);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public List<Videojuego> obtenerVideojuegoPorDesarrollador(String nombreDeDesarrollador) {
        EntityManager entityManager = getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.nombreDeDesarrollador = :nombreDeDesarrollador");
            query.setParameter("nombreDeDesarrollador", nombreDeDesarrollador);
            return query.getResultList();
        } finally {
            entityManager.close();
        }

    }

    public List<Videojuego> obtenerVideojuegosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
        EntityManager entityManager = getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v from Videojuego v where v.precio between :precioMinimo and :precioMaximo");
            query.setParameter("precioMinimo", precioMinimo);
            query.setParameter("precioMaximo", precioMaximo);
            return query.getResultList();
        } finally {
            entityManager.close();
        }

    }

    public List<Videojuego> obtenerVideojuegoPorTitulo(String tituloDelVideojuego) {
        EntityManager entityManager = getEntityManager();
        try{
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.titulo = :tituloDelVideojuego");
            query.setParameter("tituloDelVideojuego", tituloDelVideojuego);
            return query.getResultList();
        } finally {
            entityManager.close();
        }

    }

}
