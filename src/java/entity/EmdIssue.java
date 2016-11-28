/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "emd_issue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmdIssue.findAll", query = "SELECT e FROM EmdIssue e"),
    @NamedQuery(name = "EmdIssue.findById", query = "SELECT e FROM EmdIssue e WHERE e.id = :id"),
    @NamedQuery(name = "EmdIssue.findByIssuedDate", query = "SELECT e FROM EmdIssue e WHERE e.issuedDate = :issuedDate"),
    @NamedQuery(name = "EmdIssue.findByEmdAmount", query = "SELECT e FROM EmdIssue e WHERE e.emdAmount = :emdAmount"),
    @NamedQuery(name = "EmdIssue.findByEmdBy", query = "SELECT e FROM EmdIssue e WHERE e.emdBy = :emdBy"),
    @NamedQuery(name = "EmdIssue.findByChequeNo", query = "SELECT e FROM EmdIssue e WHERE e.chequeNo = :chequeNo"),
    @NamedQuery(name = "EmdIssue.findByChequeDate", query = "SELECT e FROM EmdIssue e WHERE e.chequeDate = :chequeDate"),
    @NamedQuery(name = "EmdIssue.findByIsApproved", query = "SELECT e FROM EmdIssue e WHERE e.isApproved = :isApproved"),
    @NamedQuery(name = "EmdIssue.findByIsRefunded", query = "SELECT e FROM EmdIssue e WHERE e.isRefunded = :isRefunded"),
    @NamedQuery(name = "EmdIssue.findByRefundDate", query = "SELECT e FROM EmdIssue e WHERE e.refundDate = :refundDate")})
public class EmdIssue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emd_amount")
    private double emdAmount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "emd_by")
    private String emdBy;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cheque_no")
    private String chequeNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cheque_date")
    private String chequeDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_approved")
    private boolean isApproved;
    @Column(name = "is_refunded")
    private Boolean isRefunded;
    @Column(name = "refund_date")
    @Temporal(TemporalType.DATE)
    private Date refundDate;
    @JoinColumn(name = "tender_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TenderMst tenderId;
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Supplier supplierId;

    public EmdIssue() {
    }

    public EmdIssue(Integer id) {
        this.id = id;
    }

    public EmdIssue(Integer id, Date issuedDate, double emdAmount, String emdBy, String chequeNo, String chequeDate, boolean isApproved) {
        this.id = id;
        this.issuedDate = issuedDate;
        this.emdAmount = emdAmount;
        this.emdBy = emdBy;
        this.chequeNo = chequeNo;
        this.chequeDate = chequeDate;
        this.isApproved = isApproved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public double getEmdAmount() {
        return emdAmount;
    }

    public void setEmdAmount(double emdAmount) {
        this.emdAmount = emdAmount;
    }

    public String getEmdBy() {
        return emdBy;
    }

    public void setEmdBy(String emdBy) {
        this.emdBy = emdBy;
    }

    public String getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(String chequeNo) {
        this.chequeNo = chequeNo;
    }

    public String getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(String chequeDate) {
        this.chequeDate = chequeDate;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    public Boolean getIsRefunded() {
        return isRefunded;
    }

    public void setIsRefunded(Boolean isRefunded) {
        this.isRefunded = isRefunded;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public TenderMst getTenderId() {
        return tenderId;
    }

    public void setTenderId(TenderMst tenderId) {
        this.tenderId = tenderId;
    }

    public Supplier getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Supplier supplierId) {
        this.supplierId = supplierId;
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
        if (!(object instanceof EmdIssue)) {
            return false;
        }
        EmdIssue other = (EmdIssue) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.EmdIssue[ id=" + id + " ]";
    }
    
}
