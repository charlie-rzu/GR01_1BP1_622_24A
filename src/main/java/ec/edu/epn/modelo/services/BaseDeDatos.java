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
        try {
            Query query = entityManager.createQuery("SELECT v FROM Videojuego v WHERE v.titulo = :tituloDelVideojuego");
            query.setParameter("tituloDelVideojuego", tituloDelVideojuego);
            if(query.getResultList().size() > 0){
                return (Object) query.getResultList().get(0);
            }
        } finally {
            entityManager.close();
        }
        return null;
    }
}
