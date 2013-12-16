
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
@Table(name = "group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Group1.findAll", query = "SELECT g FROM Group1 g"),
    @NamedQuery(name = "Group1.findByEntryID", query = "SELECT g FROM Group1 g WHERE g.entryID = :entryID"),
    @NamedQuery(name = "Group1.findByUsername", query = "SELECT g FROM Group1 g WHERE g.username = :username"),
    @NamedQuery(name = "Group1.findByGroupname", query = "SELECT g FROM Group1 g WHERE g.groupname = :groupname")})
public class Group1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EntryID")
    private Integer entryID;
    @Size(max = 255)
    @Column(name = "Username")
    private String username;
    @Size(max = 45)
    @Column(name = "Groupname")
    private String groupname;

    /**
     *
     */
    public Group1() {
    }

    /**
     *
     * @param entryID
     */
    public Group1(Integer entryID) {
        this.entryID = entryID;
    }

    /**
     *
     * Access method for ID key in entity
     * 
     * @return entryID
     */
    public Integer getEntryID() {
        return entryID;
    }

    /**
     *
     * Mutator method for ID key in entity
     * 
     * @param entryID
     */
    public void setEntryID(Integer entryID) {
        if (entryID == null) {
            throw new NullPointerException();
        } else {
        this.entryID = entryID;
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
     * Mutator method for title field in entity
     * 
     * @return groupname
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     *
     * Access method for title field in Entity
     * 
     * @param groupname
     */
    public void setGroupname(String groupname) {
        if (groupname == null || groupname.isEmpty()) {
            throw new NullPointerException();
        } else {
        this.groupname = groupname;
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
        hash += (entryID != null ? entryID.hashCode() : 0);
        return hash;
    }

    /**
     *
     * Equals method for matching entryIDs
     * 
     * @param object
     * @return boolean
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Group1)) {
            return false;
        }
        Group1 other = (Group1) object;
        if ((this.entryID == null && other.entryID != null) || (this.entryID != null && !this.entryID.equals(other.entryID))) {
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
        return "com.thagoondaddy.mavenbooks_amg.Group1[ entryID=" + entryID + " ]";
    }

}
