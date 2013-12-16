
package com.thagoondaddy.mavenbooks_amg.ejb;

import com.thagoondaddy.mavenbooks_amg.model.Group1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * Group1Facade class that will use all parent class methods
 * in order to do all CRUD operations, as well any other method
 * declared in the parent class
 * 
 * Group is a reserved value for JPA, thats why its called Group1
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Stateless
public class Group1Facade extends AbstractFacade<Group1> {
    @PersistenceContext(unitName = "MavenBooks_AMG_PU")
    private EntityManager em;
    
    /**
     * 
     * Creates entity manager, allows Group1Facade to use
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
    public Group1Facade() {
        super(Group1.class);
    }

}
