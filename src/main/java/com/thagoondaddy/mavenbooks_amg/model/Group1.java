
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
     * @return
     */
    public Integer getEntryID() {
        return entryID;
    }

    /**
     *
     * @param entryID
     */
    public void setEntryID(Integer entryID) {
        this.entryID = entryID;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getGroupname() {
        return groupname;
    }

    /**
     *
     * @param groupname
     */
    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryID != null ? entryID.hashCode() : 0);
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
     * @return
     */
    @Override
    public String toString() {
        return "com.thagoondaddy.mavenbooks_amg.Group1[ entryID=" + entryID + " ]";
    }

}
