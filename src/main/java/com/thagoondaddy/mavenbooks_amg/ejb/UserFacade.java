
package com.thagoondaddy.mavenbooks_amg.ejb;

import com.thagoondaddy.mavenbooks_amg.model.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "MavenBooks_AMG_PU")
    private EntityManager em;

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
