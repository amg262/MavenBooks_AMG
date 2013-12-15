
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
     * @return
     */
    public Integer getBookID() {
        return bookID;
    }

    /**
     *
     * @param bookID
     */
    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public String getImg() {
        return img;
    }

    /**
     *
     * @param img
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookID != null ? bookID.hashCode() : 0);
        return hash;
    }

    /**
     *
     * @param object
     * @return
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
     * @return
     */
    @Override
    public String toString() {
        return "com.thagoondaddy.mavenbooks_amg.Book[ bookID=" + bookID + " ]";
    }

}
