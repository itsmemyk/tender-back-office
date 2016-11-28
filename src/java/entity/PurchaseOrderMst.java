/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "purchase_order_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderMst.findAll", query = "SELECT p FROM PurchaseOrderMst p"),
    @NamedQuery(name = "PurchaseOrderMst.findById", query = "SELECT p FROM PurchaseOrderMst p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseOrderMst.findByOrderDate", query = "SELECT p FROM PurchaseOrderMst p WHERE p.orderDate = :orderDate"),
    @NamedQuery(name = "PurchaseOrderMst.findByNetTotal", query = "SELECT p FROM PurchaseOrderMst p WHERE p.netTotal = :netTotal"),
    @NamedQuery(name = "PurchaseOrderMst.findByIsApproved", query = "SELECT p FROM PurchaseOrderMst p WHERE p.isApproved = :isApproved")})
public class PurchaseOrderMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_date")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "net_total")
    private double netTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_approved")
    private boolean isApproved;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierId;
    @JoinColumn(name = "tender_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TenderMst tenderId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "purchaseOrderId")
    private Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection;

    public PurchaseOrderMst() {
    }

    public PurchaseOrderMst(Integer id) {
        this.id = id;
    }

    public PurchaseOrderMst(Integer id, Date orderDate, double netTotal, boolean isApproved) {
        this.id = id;
        this.orderDate = orderDate;
        this.netTotal = netTotal;
        this.isApproved = isApproved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getNetTotal() {
        return netTotal;
    }

    public void setNetTotal(double netTotal) {
        this.netTotal = netTotal;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public TenderMst getTenderId() {
        return tenderId;
    }

    public void setTenderId(TenderMst tenderId) {
        this.tenderId = tenderId;
    }

    @XmlTransient
    public Collection<PurchaseOrderDetails> getPurchaseOrderDetailsCollection() {
        return purchaseOrderDetailsCollection;
    }

    public void setPurchaseOrderDetailsCollection(Collection<PurchaseOrderDetails> purchaseOrderDetailsCollection) {
        this.purchaseOrderDetailsCollection = purchaseOrderDetailsCollection;
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
        if (!(object instanceof PurchaseOrderMst)) {
            return false;
        }
        PurchaseOrderMst other = (PurchaseOrderMst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PurchaseOrderMst[ id=" + id + " ]";
    }
    
}
