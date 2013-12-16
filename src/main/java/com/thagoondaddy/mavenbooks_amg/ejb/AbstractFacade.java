
package com.thagoondaddy.mavenbooks_amg.ejb;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * Abstract facade class that contains all the CRUD methods that will be
 * inherited by specific entity classes, allowing this abstract class
 * to contain all the methods thosde classes will use.
 * 
 * While there is some rigidity due to code inheritance, I chose to save
 * time and reuse code in this situation due to the similar needs of those
 * classes.
 * 
 * @param <T> 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    /**
     *
     * Constructor that exceptions a generic class as an argument
     * 
     * @param entityClass
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     *
     * Each class that extend will implement this, allows all CRUD to be done
     * 
     * @return entity manager
     */
    protected abstract EntityManager getEntityManager();

    /**
     *
     * Method other entity facades will inherit to Create a new entity
     * 
     * @param entity
     */
    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    /**
     *
     * Method other entity facades will inherit to Edit a new entity
     * 
     * @param entity
     */
    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    /**
     *
     * Method other entity facades will inherit to Destroy a new entity
     * 
     * @param entity
     */
    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    /**
     * 
     * Method other entity facades will inherit to Find an entity
     * Will search by ID, uses generic
     * 
     * @param id
     * @return getEntityManager().find(entityClass, id);
     */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    /**
     * 
     * Method other entity facades will inherit to Find all entites
     * Uses generic
     * 
     * @return getEntityManager().createQuery(cq).getResultList();
     */
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    /**
     *
     * Finds range of records based on the passed in integer
     * 
     * @param range
     * @return q.getResultList();
     */
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /**
     *
     * Counts the amount of records present
     * 
     * @return ((Long) q.getSingleResult()).intValue();
     */
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
