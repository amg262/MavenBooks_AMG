
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserID", query = "SELECT u FROM User u WHERE u.userID = :userID"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "UserID")
    private Integer userID;
    @Size(max = 255)
    @Column(name = "Username")
    private String username;
    @Size(max = 255)
    @Column(name = "Password")
    private String password;

    /**
     *
     */
    public User() {
    }

    /**
     *
     * @param userID
     */
    public User(Integer userID) {
        this.userID = userID;
    }

    /**
     *
     * Access method for ID key in entity
     * 
     * @return userID
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     *
     * Mutator method for ID key in entity
     * 
     * @param userID
     */
    public void setUserID(Integer userID) {
        if (userID == null) {
            throw new NullPointerException();
        } else {
        this.userID = userID;
    }}

    /**
     *
     * Access method for username field in Entity
     * 
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * Mutator method for username field in entity
     * 
     * @param username
     */
    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new NullPointerException();
        } else {
        this.username = username;
    }}

    /**
     *
     * Mutator method for password field in entity
     * 
     * @param password
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * Mutator method for username field in entity
     * 
     * @param username
     */
    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new NullPointerException();
        } else {
        this.password = password;
    }}

    /**
     *
     * Hash code method for entryID field
     * 
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    /**
     *
     * Equals method for matching userID
     * 
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return toString()
     */
    @Override
    public String toString() {
        return "com.thagoondaddy.mavenbooks_amg.User[ userID=" + userID + " ]";
    }

}
