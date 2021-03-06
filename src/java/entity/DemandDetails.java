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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "demand_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DemandDetails.findAll", query = "SELECT d FROM DemandDetails d"),
    @NamedQuery(name = "DemandDetails.findById", query = "SELECT d FROM DemandDetails d WHERE d.id = :id"),
    @NamedQuery(name = "DemandDetails.findByQty", query = "SELECT d FROM DemandDetails d WHERE d.qty = :qty")})
public class DemandDetails implements Serializable {
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
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierId;
    @JoinColumn(name = "demand_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private DemandMst demandId;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMst itemId;

    public DemandDetails() {
    }

    public DemandDetails(Integer id) {
        this.id = id;
    }

    public DemandDetails(Integer id, int qty) {
        this.id = id;
        this.qty = qty;
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

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
    }

    public DemandMst getDemandId() {
        return demandId;
    }

    public void setDemandId(DemandMst demandId) {
        this.demandId = demandId;
    }

    public ItemMst getItemId() {
        return itemId;
    }

    public void setItemId(ItemMst itemId) {
        this.itemId = itemId;
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
        if (!(object instanceof DemandDetails)) {
            return false;
        }
        DemandDetails other = (DemandDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DemandDetails[ id=" + id + " ]";
    }
    
}
