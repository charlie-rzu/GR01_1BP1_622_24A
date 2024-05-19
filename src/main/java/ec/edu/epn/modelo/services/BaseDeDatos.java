package ec.edu.epn.modelo.services;

import ec.edu.epn.modelo.entidad.Videojuego;
import jakarta.persistence.*;
import java.util.List;

public class BaseDeDatos {
    public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("GR01_1BP1_622_24A_PU");
    public static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public static EntityTransaction transaction = entityManager.getTransaction();

    public static void finalizarConexion(){
        entityManager.close();
        entityManagerFactory.close();
    }

    public static void persistirObjeto(Object objetoAPersistirEnLaBD){
        try{
            transaction.begin();
            entityManager.persist(objetoAPersistirEnLaBD);
            transaction.commit();
        }catch (Exception e){
            if(transaction.isActive()){
                transaction.rollback();
            }
        }
    }
    public static <T> List<T> obtenerTabla(Class<T> clase){
        TypedQuery<T> query = entityManager.createQuery("SELECT c FROM "+clase.getSimpleName()+" c", clase);
        return query.getResultList();
    }

    public static List<Videojuego> obtenerVideojuegoPorDesarrollador(String nombreDeDesarrollador) {
        try {
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.nombreDeDesarrollador = :nombreDeDesarrollador");
            query.setParameter("nombreDeDesarrollador", nombreDeDesarrollador);
            return query.getResultList();
        } finally {
            entityManager.close();
        }
    }

    public static Object obtenerVideojuegosPorRangoDePrecio(double precioMinimo, double precioMaximo) {
        Query query = entityManager.createQuery("SELECT v from Videojuego v where v.precio between :precioMinimo and :precioMaximo");
        query.setParameter("precioMinimo", precioMinimo);
        query.setParameter("precioMaximo", precioMaximo);
        return query.getResultList();
    }

    public boolean existVideojuegoByName(String tituloABuscar) {
        try {
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.titulo = :tituloABuscar");
            query.setParameter("tituloABuscar", tituloABuscar);
            if(query.getResultList().size() > 0){
                return true;
            }
            return false;
        } finally {
            entityManager.close();
        }
    }
    public static Object obtenerVideojuegoPorTitulo(String tituloDelVideojuego) {
        System.out.printf(String.valueOf(tituloDelVideojuego.getClass()));
        try {
            Query query = entityManager.createQuery("SELECT v FROM "+tituloDelVideojuego.getClass() +" v WHERE v.titulo = :tituloDelVideojuego");
            query.setParameter("tituloDelVideojuego", tituloDelVideojuego);
            if(query.getResultList().size() > 0){
                return (Object) query.getSingleResult();
            }
        } finally {
            entityManager.close();
        }
        return null;
    }
}
