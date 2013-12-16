
package com.thagoondaddy.mavenbooks_amg.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * Entity class that was generated from an existing database table. Contains
 * all necessary named queries, annotations regarding Entity class, table name,
 * identifier, columns and their lengths as well as all the methods used to
 * manipulate the data in the particular entity table.
 * 
 * @author Andrew Gunn | amgunn1@hotmail.com
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.findByBookID", query = "SELECT b FROM Book b WHERE b.bookID = :bookID"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.findByDescription", query = "SELECT b FROM Book b WHERE b.description = :description"),
    @NamedQuery(name = "Book.findByPrice", query = "SELECT b FROM Book b WHERE b.price = :price"),
    @NamedQuery(name = "Book.findByImg", query = "SELECT b FROM Book b WHERE b.img = :img")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BookID")
    private Integer bookID;
    @Size(max = 255)
    @Column(name = "Title")
    private String title;
    @Size(max = 255)
    @Column(name = "Description")
    private String description;
    @Size(max = 255)
    @Column(name = "Price")
    private String price;
    @Size(max = 255)
    @Column(name = "Img")
    private String img;

    /**
     *
     */
    public Book() {
    }

    /**
     *
     * @param bookID
     */
    public Book(Integer bookID) {
        this.bookID = bookID;
    }

    /**
     *
     * Access method for ID key in entity
     * 
     * @return bookID
     */
    public Integer getBookID() {
        return bookID;
    }

    /**
     *
     * Mutator method for ID key in entity
     * 
     * @param bookID
     */
    public void setBookID(Integer bookID) {
        if (bookID == null) {
            throw new NullPointerException();
        } else {
        this.bookID = bookID;
    }}

    /**
     *
     * Access method for title field in Entity
     * 
     * @return title
     */ 
    public String getTitle() {
        return title;
    }

    /**
     *
     * Mutator method for title field in entity
     * 
     * @param title
     */
    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new NullPointerException();
        } else {
        this.title = title;
    }}

    /**
     *
     * Accessor method for description field of entity
     * 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * Mutator method of description field of entity
     * 
     * @param description
     */
    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new NullPointerException();
        } else {
        this.description = description;
    }}

    /**
     * 
     * Accessor method for price field in entity
     *
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * Mutator method for price field in entity
     * 
     * @param price
     */
    public void setPrice(String price) {
        if (price == null) {
            throw new NullPointerException();
        } else {
        this.price = price;
    }}

    /**
     *
     * Mutator method for Img url for entity
     * 
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     *
     * Mutator method for img url of entity
     * 
     * @param img
     */
    public void setImg(String img) {
        if (img == null) {
            throw new NullPointerException();
        } else {
        this.img = img;
    }}

    /**
     *
     * Hash code method for bookID field
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookID != null ? bookID.hashCode() : 0);
        return hash;
    }

    /**
     *
     * Equals method for matching bookIDs
     * 
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.bookID == null && other.bookID != null) || (this.bookID != null && !this.bookID.equals(other.bookID))) {
            return false;
        }
        return true;
    }

    /**
     *
     * Overridden tosTring
     * 
     * @return String
     */
    @Override
    public String toString() {
        return bookID + " " + title + " " + description + " " + price;
    }

}
