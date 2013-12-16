
package com.thagoondaddy.mavenbooks_amg.ejb;

import com.thagoondaddy.mavenbooks_amg.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * UserFacde class that will use all parent class methods
 * in order to do all CRUD operations, as well any other method
 * declared in the parent class
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "MavenBooks_AMG_PU")
    private EntityManager em;

    /**
     * 
     * Creates entity manager, allows UserFacde to use
     * all the methods created in parent class
     * 
     * @return em
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public UserFacade() {
        super(User.class);
    }

}
