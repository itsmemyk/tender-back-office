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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "item_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemMst.findAll", query = "SELECT i FROM ItemMst i"),
    @NamedQuery(name = "ItemMst.findById", query = "SELECT i FROM ItemMst i WHERE i.id = :id"),
    @NamedQuery(name = "ItemMst.findByName", query = "SELECT i FROM ItemMst i WHERE i.name = :name")})
public class ItemMst implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<TenderDetails> tenderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<QuotationDetails> quotationDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CompanyMst companyId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<DemandDetails> demandDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private Collection<StockMst> stockMstCollection;

    public ItemMst() {
    }

    public ItemMst(Integer id) {
        this.id = id;
    }

    public ItemMst(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public Collection<TenderDetails> getTenderDetailsCollection() {
        return tenderDetailsCollection;
    }

    public void setTenderDetailsCollection(Collection<TenderDetails> tenderDetailsCollection) {
        this.tenderDetailsCollection = tenderDetailsCollection;
    }

    @XmlTransient
    public Collection<QuotationDetails> getQuotationDetailsCollection() {
        return quotationDetailsCollection;
    }

    public void setQuotationDetailsCollection(Collection<QuotationDetails> quotationDetailsCollection) {
        this.quotationDetailsCollection = quotationDetailsCollection;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetails> getPurchaseOrderDetailsCollection() {
        return purchaseOrderDetailsCollection;
    }

    public void setPurchaseOrderDetailsCollection(Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection) {
        this.purchaseOrderDetailsCollection = purchaseOrderDetailsCollection;
    }

    public CompanyMst getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyMst companyId) {
        this.companyId = companyId;
    }

    @XmlTransient
    public Collection<DemandDetails> getDemandDetailsCollection() {
        return demandDetailsCollection;
    }

    public void setDemandDetailsCollection(Collection<DemandDetails> demandDetailsCollection) {
        this.demandDetailsCollection = demandDetailsCollection;
    }

    @XmlTransient
    public Collection<StockMst> getStockMstCollection() {
        return stockMstCollection;
    }

    public void setStockMstCollection(Collection<StockMst> stockMstCollection) {
        this.stockMstCollection = stockMstCollection;
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
        if (!(object instanceof ItemMst)) {
            return false;
        }
        ItemMst other = (ItemMst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ItemMst[ id=" + id + " ]";
    }
    
}
