
package com.thagoondaddy.mavenbooks_amg.ejb;

import com.thagoondaddy.mavenbooks_amg.model.Book;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * 
 * BookFacade class that will use all parent class methods
 * in order to do all CRUD operations, as well any other method
 * declared in the parent class
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> {
    @PersistenceContext(unitName = "MavenBooks_AMG_PU")
    private EntityManager em;

    /**
     * 
     * Creates entity manager, allows BookFacade to use
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
    public BookFacade() {
        super(Book.class);
    }

}
