package ec.edu.epn.modelo.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;

public class PersistenciaBD {

    public PersistenciaBD() {
    }

    public int persist(Object object) {
        int transactionResult;

        try {
            persistObject(object);
            transactionResult = 0;
        } catch (Exception e) {
            rollbackTransaction();
            transactionResult = 1;
        } finally {
            BaseDeDatos.finalizarConexion();
        }

        return transactionResult;
    }

    private void createConection() {
        BaseDeDatos.transaction.begin();
    }

    private void rollbackTransaction() {
        if (BaseDeDatos.transaction.isActive()) {
            BaseDeDatos.transaction.rollback();
        }
    }

    private <T> void persistObject(T entityClass) {
        createConection();
        BaseDeDatos.entityManager.persist(entityClass);
        commitTransaction();
    }

    public <T> List<T> getAll(Class<T> entityClass) {
        createConection();
        CriteriaBuilder criteriaBuilder = BaseDeDatos.entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass); //movi algo no se que
        criteriaQuery.from(entityClass);
        List<T> resultList = BaseDeDatos.entityManager.createQuery(criteriaQuery).getResultList();
        commitTransaction();
        return resultList;
    }

    private void commitTransaction() {
        BaseDeDatos.transaction.commit();
    }



}

