
package com.thagoondaddy.mavenbooks_amg.ejb;

import com.thagoondaddy.mavenbooks_amg.model.Group1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Stateless
public class Group1Facade extends AbstractFacade<Group1> {
    @PersistenceContext(unitName = "MavenBooks_AMG_PU")
    private EntityManager em;

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
