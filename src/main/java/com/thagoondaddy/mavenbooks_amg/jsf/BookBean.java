
package com.thagoondaddy.mavenbooks_amg.jsf;

import com.thagoondaddy.mavenbooks_amg.ejb.BookFacade;
import com.thagoondaddy.mavenbooks_amg.model.Book;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Named
@SessionScoped
public class BookBean implements Serializable {
    private static final long serializableUID = 1L;
    
    private List<Book> allBooks;
    private List<Book> order;
    
    @Inject
    private BookFacade facade;

    /**
     * @return the allBooks
     */
    public List<Book> getAllBooks() {
        return facade.findAll();
    }

    /**
     * @param allBooks the allBooks to set
     */
    public void setAllBooks(List<Book> allBooks) {
        this.allBooks = allBooks;
    }

    /**
     * @return the order
     */
    public List<Book> getOrder() {
        return order;
    }

    /**
     * @param order the order to set
     */
    public void setOrder(List<Book> order) {
        this.order = order;
    }
    
    
}
