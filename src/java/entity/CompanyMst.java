/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "company_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompanyMst.findAll", query = "SELECT c FROM CompanyMst c"),
    @NamedQuery(name = "CompanyMst.findById", query = "SELECT c FROM CompanyMst c WHERE c.id = :id"),
    @NamedQuery(name = "CompanyMst.findByName", query = "SELECT c FROM CompanyMst c WHERE c.name = :name"),
    @NamedQuery(name = "CompanyMst.findByIsActive", query = "SELECT c FROM CompanyMst c WHERE c.isActive = :isActive")})
public class CompanyMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<QuotationDetails> quotationDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private Collection<ItemMst> itemMstCollection;

    public CompanyMst() {
    }

    public CompanyMst(Integer id) {
        this.id = id;
    }

    public CompanyMst(Integer id, String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<QuotationDetails> getQuotationDetailsCollection() {
        return quotationDetailsCollection;
    }

    public void setQuotationDetailsCollection(Collection<QuotationDetails> quotationDetailsCollection) {
        this.quotationDetailsCollection = quotationDetailsCollection;
    }

    @XmlTransient
    public Collection<ItemMst> getItemMstCollection() {
        return itemMstCollection;
    }

    public void setItemMstCollection(Collection<ItemMst> itemMstCollection) {
        this.itemMstCollection = itemMstCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompanyMst)) {
            return false;
        }
        CompanyMst other = (CompanyMst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CompanyMst[ id=" + id + " ]";
    }
    
}
