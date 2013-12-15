
package com.thagoondaddy.mavenbooks_amg.jsf;

import com.thagoondaddy.mavenbooks_amg.exceptions.NonexistentEntityException;
import com.thagoondaddy.mavenbooks_amg.exceptions.RollbackFailureException;
import com.thagoondaddy.mavenbooks_amg.model.Group1;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
public class Group1JpaController implements Serializable {

    /**
     *
     * @param utx
     * @param emf
     */
    public Group1JpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    /**
     *
     * @return
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     *
     * @param group1
     * @throws RollbackFailureException
     * @throws Exception
     */
    public void create(Group1 group1) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(group1);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param group1
     * @throws NonexistentEntityException
     * @throws RollbackFailureException
     * @throws Exception
     */
    public void edit(Group1 group1) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            group1 = em.merge(group1);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = group1.getEntryID();
                if (findGroup1(id) == null) {
                    throw new NonexistentEntityException("The group1 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param id
     * @throws NonexistentEntityException
     * @throws RollbackFailureException
     * @throws Exception
     */
    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Group1 group1;
            try {
                group1 = em.getReference(Group1.class, id);
                group1.getEntryID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The group1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(group1);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @return
     */
    public List<Group1> findGroup1Entities() {
        return findGroup1Entities(true, -1, -1);
    }

    /**
     *
     * @param maxResults
     * @param firstResult
     * @return
     */
    public List<Group1> findGroup1Entities(int maxResults, int firstResult) {
        return findGroup1Entities(false, maxResults, firstResult);
    }

    private List<Group1> findGroup1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Group1.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Group1 findGroup1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Group1.class, id);
        } finally {
            em.close();
        }
    }

    /**
     *
     * @return
     */
    public int getGroup1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Group1> rt = cq.from(Group1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
