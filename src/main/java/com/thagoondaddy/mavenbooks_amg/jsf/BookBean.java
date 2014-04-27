package com.thagoondaddy.mavenbooks_amg.jsf;

import com.thagoondaddy.mavenbooks_amg.model.Book;
import com.thagoondaddy.mavenbooks_amg.jsf.util.JsfUtil;
import com.thagoondaddy.mavenbooks_amg.jsf.util.PaginationHelper;
import com.thagoondaddy.mavenbooks_amg.ejb.BookFacade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

/**
 *
 * Session scoped Book backing bean that will uses the SOA to do anything
 * needed when its comes to Book objects from the database, as well as other 
 * operations specific to books such as getting the order, or all books
 * 
 * @author Andy
 */
@Named("bookController")
@SessionScoped
public class BookBean implements Serializable {
    private static final long serializableUID = 1L;
    
    private Book current;
    private DataModel items = null;
    @EJB
    @Inject
    private com.thagoondaddy.mavenbooks_amg.ejb.BookFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private List<Book> allBooks;
    private List<Book> order;

    /**
     *
     */
    public BookBean() {
    }

    /**
     *
     * Method that returns the selected object
     * 
     * @return current book selected
     */
    public Book getSelected() {
        if (current == null) {
            current = new Book();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    /**
     * 
     * Gets the ejb Facade uses for this backing bean class and
     * the corresponding entity class
     * 
     * @return ejbFacade
     */
    private BookFacade getFacade() {
        return ejbFacade;
    }

    /**
     *
     * Creates separate pages for each CRUD operation
     *
     * @return pagination
     */
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    /**
     * 
     * Recreates model
     * 
     * @return List
     */
    public String prepareList() {
        recreateModel();
        return "List";
    }

    /**
     *
     * Prepares view for all CRUD capabilites
     * 
     * @return View
     */
    public String prepareView() {
        current = (Book) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    /**
     *
     * Prepares view for the Creation of a new record
     * 
     * @return Create
     */
    public String prepareCreate() {
        current = new Book();
        selectedItemIndex = -1;
        return "Create";
    }

    /**
     *
     * Uses the ejb facade to do actual creation of new object
     * 
     * @return String
     */
    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("BookCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    /**
     *
     * Prepares the view for editing a record
     * 
     * @return Edit
     */
    public String prepareEdit() {
        current = (Book) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    /**
     *
     * Uses the ejb facade to do the Editing/updating of a record
     * 
     * @return String
     */
    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("BookUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    /**
     *
     * Method used to destroy, or delete a record
     * 
     * @return List
     */
    public String destroy() {
        current = (Book) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    /**
     *
     * Destroys object and recreates the view afterwards
     * 
     * @return View/List
     */
    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    /**
     * Destroys the selected object using the Ejb Facade 
     */
    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("BookDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    /**
     * updates the current item when called
     */
    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    /**
     *
     * Sets items equal to a data model
     * 
     * @return the items from DB to the page
     */
    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    /**
     * Recreates the page model
     */
    private void recreateModel() {
        items = null;
    }

    /**
     * Recreates the pagination for the different
     * page crud operations
     */
    private void recreatePagination() {
        pagination = null;
    }

    /**
     *
     * Changes to next page of create, list, view, destroy
     * 
     * @return List
     */
    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    /**
     *
     * Changes to previous page of create, list, view, destroy
     * 
     * @return List
     */
    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    /**
     *
     * Gets an array of selected available items
     * 
     * @return sfUtil.getSelectItems(ejbFacade.findAll(), false);
     */
    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    /**
     * 
     * Gets an array of selected available items. 
     * 
     * @return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
     */
    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    /**
     *
     * Gets the entity object based on the passed in ID object
     * 
     * @param id 
     * @return ejbFacade.find(id);
     */
    public Book getBook(java.lang.Integer id) {
        return ejbFacade.find(id);
    }
    
    
    /**
     * 
     * Gets all objects using ejbFacade
     * 
     * @return the allBooks
     */
    public List<Book> getAllBooks() {
        return ejbFacade.findAll();
    }


    /**
     * 
     * List of books that are selected by user and added to the cart
     * 
     * @return the order
     */
    public List<Book> getOrder() {
        return order;
    }

    /**
     * 
     * Sets the order with a list of book objects selected by user
     * 
     * @param order the order to set
     */
    public void setOrder(List<Book> order) {
        this.order = order;
    }
    
    
    /**
     * 
     * Method used for getting the final bill of order
     * 
     * @return total
     */
    public double getBill(){
        double total = 0;
        for (Book b : order){
            total += b.getPrice();
        }
        return total;
    }
    
    /**
     * 
     * returns bill and tax combined (final bill)
     * 
     * @return bill + tax
     */
    public double getTaxAndBill(){
        return getBill() * .05;
    }
    
    /**
     * 
     * Sends you to confirmation page if good
     * 
     * @return confirmation
     */
    public String processOrder(){
        return "confirmation";
    }

}
