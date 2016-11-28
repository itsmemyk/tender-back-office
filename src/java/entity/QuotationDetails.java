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
@Table(name = "quotation_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuotationDetails.findAll", query = "SELECT q FROM QuotationDetails q"),
    @NamedQuery(name = "QuotationDetails.findById", query = "SELECT q FROM QuotationDetails q WHERE q.id = :id"),
    @NamedQuery(name = "QuotationDetails.findByUnitWiseQty", query = "SELECT q FROM QuotationDetails q WHERE q.unitWiseQty = :unitWiseQty"),
    @NamedQuery(name = "QuotationDetails.findByUnitWisePrice", query = "SELECT q FROM QuotationDetails q WHERE q.unitWisePrice = :unitWisePrice"),
    @NamedQuery(name = "QuotationDetails.findByIsIssued", query = "SELECT q FROM QuotationDetails q WHERE q.isIssued = :isIssued"),
    @NamedQuery(name = "QuotationDetails.findByItemQty", query = "SELECT q FROM QuotationDetails q WHERE q.itemQty = :itemQty")})
public class QuotationDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_wise_qty")
    private int unitWiseQty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_wise_price")
    private double unitWisePrice;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "remark")
    private String remark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_issued")
    private boolean isIssued;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "item_qty")
    private String itemQty;
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CompanyMst companyId;
    @JoinColumn(name = "tender_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TenderMst tenderId;
    @JoinColumn(name = "quotation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private QuotationMst quotationId;
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemMst itemId;

    public QuotationDetails() {
    }

    public QuotationDetails(Integer id) {
        this.id = id;
    }

    public QuotationDetails(Integer id, int unitWiseQty, double unitWisePrice, String remark, boolean isIssued, String itemQty) {
        this.id = id;
        this.unitWiseQty = unitWiseQty;
        this.unitWisePrice = unitWisePrice;
        this.remark = remark;
        this.isIssued = isIssued;
        this.itemQty = itemQty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUnitWiseQty() {
        return unitWiseQty;
    }

    public void setUnitWiseQty(int unitWiseQty) {
        this.unitWiseQty = unitWiseQty;
    }

    public double getUnitWisePrice() {
        return unitWisePrice;
    }

    public void setUnitWisePrice(double unitWisePrice) {
        this.unitWisePrice = unitWisePrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean getIsIssued() {
        return isIssued;
    }

    public void setIsIssued(boolean isIssued) {
        this.isIssued = isIssued;
    }

    public String getItemQty() {
        return itemQty;
    }

    public void setItemQty(String itemQty) {
        this.itemQty = itemQty;
    }

    public CompanyMst getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyMst companyId) {
        this.companyId = companyId;
    }

    public TenderMst getTenderId() {
        return tenderId;
    }

    public void setTenderId(TenderMst tenderId) {
        this.tenderId = tenderId;
    }

    public QuotationMst getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(QuotationMst quotationId) {
        this.quotationId = quotationId;
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
        if (!(object instanceof QuotationDetails)) {
            return false;
        }
        QuotationDetails other = (QuotationDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.QuotationDetails[ id=" + id + " ]";
    }
    
}
