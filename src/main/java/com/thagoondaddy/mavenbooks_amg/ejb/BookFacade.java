
package com.thagoondaddy.mavenbooks_amg.ejb;

import com.thagoondaddy.mavenbooks_amg.model.Book;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> {
    @PersistenceContext(unitName = "MavenBooks_AMG_PU")
    private EntityManager em;

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
