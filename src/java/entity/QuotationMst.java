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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "quotation_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuotationMst.findAll", query = "SELECT q FROM QuotationMst q"),
    @NamedQuery(name = "QuotationMst.findById", query = "SELECT q FROM QuotationMst q WHERE q.id = :id"),
    @NamedQuery(name = "QuotationMst.findByTenderId", query = "SELECT q FROM QuotationMst q WHERE q.tenderId = :tenderId"),
    @NamedQuery(name = "QuotationMst.findByQDate", query = "SELECT q FROM QuotationMst q WHERE q.qDate = :qDate"),
    @NamedQuery(name = "QuotationMst.findBySupplierId", query = "SELECT q FROM QuotationMst q WHERE q.supplierId = :supplierId")})
public class QuotationMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tender_id")
    private int tenderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "q_date")
    @Temporal(TemporalType.DATE)
    private Date qDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "supplier_id")
    private int supplierId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "remark")
    private String remark;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quotationId")
    private Collection<QuotationDetails> quotationDetailsCollection;

    public QuotationMst() {
    }

    public QuotationMst(Integer id) {
        this.id = id;
    }

    public QuotationMst(Integer id, int tenderId, Date qDate, int supplierId, String remark) {
        this.id = id;
        this.tenderId = tenderId;
        this.qDate = qDate;
        this.supplierId = supplierId;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTenderId() {
        return tenderId;
    }

    public void setTenderId(int tenderId) {
        this.tenderId = tenderId;
    }

    public Date getQDate() {
        return qDate;
    }

    public void setQDate(Date qDate) {
        this.qDate = qDate;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @XmlTransient
    public Collection<QuotationDetails> getQuotationDetailsCollection() {
        return quotationDetailsCollection;
    }

    public void setQuotationDetailsCollection(Collection<QuotationDetails> quotationDetailsCollection) {
        this.quotationDetailsCollection = quotationDetailsCollection;
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
        if (!(object instanceof QuotationMst)) {
            return false;
        }
        QuotationMst other = (QuotationMst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.QuotationMst[ id=" + id + " ]";
    }
    
}
