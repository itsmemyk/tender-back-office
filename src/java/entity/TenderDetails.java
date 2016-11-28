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
@Table(name = "tender_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TenderDetails.findAll", query = "SELECT t FROM TenderDetails t"),
    @NamedQuery(name = "TenderDetails.findById", query = "SELECT t FROM TenderDetails t WHERE t.id = :id"),
    @NamedQuery(name = "TenderDetails.findByQty", query = "SELECT t FROM TenderDetails t WHERE t.qty = :qty")})
public class TenderDetails implements Serializable {
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
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "remark")
    private String remark;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMst itemId;
    @JoinColumn(name = "tender_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TenderMst tenderId;

    public TenderDetails() {
    }

    public TenderDetails(Integer id) {
        this.id = id;
    }

    public TenderDetails(Integer id, int qty, String remark) {
        this.id = id;
        this.qty = qty;
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

    public TenderMst getTenderId() {
        return tenderId;
    }

    public void setTenderId(TenderMst tenderId) {
        this.tenderId = tenderId;
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
        if (!(object instanceof TenderDetails)) {
            return false;
        }
        TenderDetails other = (TenderDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TenderDetails[ id=" + id + " ]";
    }
    
}
