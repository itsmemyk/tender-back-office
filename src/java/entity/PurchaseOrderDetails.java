/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "purchase_order_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseOrderDetails.findAll", query = "SELECT p FROM PurchaseOrderDetails p"),
    @NamedQuery(name = "PurchaseOrderDetails.findById", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseOrderDetails.findByQty", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.qty = :qty"),
    @NamedQuery(name = "PurchaseOrderDetails.findByPurchaseAmt", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.purchaseAmt = :purchaseAmt"),
    @NamedQuery(name = "PurchaseOrderDetails.findByTotal", query = "SELECT p FROM PurchaseOrderDetails p WHERE p.total = :total")})
public class PurchaseOrderDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty")
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "purchase_amt")
    private double purchaseAmt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "remark")
    private String remark;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMst itemId;
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseOrderMst purchaseOrderId;

    public PurchaseOrderDetails() {
    }

    public PurchaseOrderDetails(Integer id) {
        this.id = id;
    }

    public PurchaseOrderDetails(Integer id, int qty, double purchaseAmt, double total, String remark) {
        this.id = id;
        this.qty = qty;
        this.purchaseAmt = purchaseAmt;
        this.total = total;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPurchaseAmt() {
        return purchaseAmt;
    }

    public void setPurchaseAmt(double purchaseAmt) {
        this.purchaseAmt = purchaseAmt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public ItemMst getItemId() {
        return itemId;
    }

    public void setItemId(ItemMst itemId) {
        this.itemId = itemId;
    }

    public PurchaseOrderMst getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(PurchaseOrderMst purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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
        if (!(object instanceof PurchaseOrderDetails)) {
            return false;
        }
        PurchaseOrderDetails other = (PurchaseOrderDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.PurchaseOrderDetails[ id=" + id + " ]";
    }
    
}
