package com.thagoondaddy.mavenbooks_amg.jsf.util;

import javax.faces.model.DataModel;

/**
 * 
 * Abstract class that will contain methods other classes will inherit
 * regarding the pagination functions that create the CRUD functional
 * pages for all the entity objects in the scope of this application
 *
 * @author Andy
 */
public abstract class PaginationHelper {

    private int pageSize;
    private int page;

    /**
     *
     * @param pageSize
     */
    public PaginationHelper(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     *
     * Counts total items
     * 
     * @return int
     */
    public abstract int getItemsCount();

    /**
     *
     * Creates the page data model for the View
     * 
     * @return DataModel
     */
    public abstract DataModel createPageDataModel();

    /**
     *
     * Get first item on page
     * 
     * @return page * pageSize
     */
    public int getPageFirstItem() {
        return page * pageSize;
    }

    /**
     *
     * Gets last item on page
     * 
     * @return int
     */
    public int getPageLastItem() {
        int i = getPageFirstItem() + pageSize - 1;
        int count = getItemsCount() - 1;
        if (i > count) {
            i = count;
        }
        if (i < 0) {
            i = 0;
        }
        return i;
    }

    /**
     *
     * Boolean if the pagination has another page
     * 
     * @return boolean
     */
    public boolean isHasNextPage() {
        return (page + 1) * pageSize + 1 <= getItemsCount();
    }

    /**
     * Proceeds to next page
     */
    public void nextPage() {
        if (isHasNextPage()) {
            page++;
        }
    }

    /**
     *
     * Boolean if the pagination has prev page
     * 
     * @return boolean
     */
    public boolean isHasPreviousPage() {
        return page > 0;
    }

    /**
     * Goes back to prev page
     */
    public void previousPage() {
        if (isHasPreviousPage()) {
            page--;
        }
    }

    /**
     *
     * Gets page size
     * 
     * @return int
     */
    public int getPageSize() {
        return pageSize;
    }
}
