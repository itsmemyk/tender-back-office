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
@Table(name = "tender_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TenderMst.findAll", query = "SELECT t FROM TenderMst t"),
    @NamedQuery(name = "TenderMst.findById", query = "SELECT t FROM TenderMst t WHERE t.id = :id"),
    @NamedQuery(name = "TenderMst.findByPubDate", query = "SELECT t FROM TenderMst t WHERE t.pubDate = :pubDate"),
    @NamedQuery(name = "TenderMst.findBySubmittedDate", query = "SELECT t FROM TenderMst t WHERE t.submittedDate = :submittedDate"),
    @NamedQuery(name = "TenderMst.findByEmd", query = "SELECT t FROM TenderMst t WHERE t.emd = :emd"),
    @NamedQuery(name = "TenderMst.findByDocCost", query = "SELECT t FROM TenderMst t WHERE t.docCost = :docCost"),
    @NamedQuery(name = "TenderMst.findByDeadlineDate", query = "SELECT t FROM TenderMst t WHERE t.deadlineDate = :deadlineDate"),
    @NamedQuery(name = "TenderMst.findByDeadlineTime", query = "SELECT t FROM TenderMst t WHERE t.deadlineTime = :deadlineTime"),
    @NamedQuery(name = "TenderMst.findByOpeningDate", query = "SELECT t FROM TenderMst t WHERE t.openingDate = :openingDate"),
    @NamedQuery(name = "TenderMst.findByIsApproved", query = "SELECT t FROM TenderMst t WHERE t.isApproved = :isApproved")})
public class TenderMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pub_date")
    @Temporal(TemporalType.DATE)
    private Date pubDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "pub_desc")
    private String pubDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "submitted_date")
    @Temporal(TemporalType.DATE)
    private Date submittedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "emd")
    private double emd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "doc_cost")
    private double docCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deadline_date")
    @Temporal(TemporalType.DATE)
    private Date deadlineDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deadline_time")
    @Temporal(TemporalType.TIME)
    private Date deadlineTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "opening_date")
    @Temporal(TemporalType.DATE)
    private Date openingDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "press_note_loc")
    private String pressNoteLoc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_approved")
    private boolean isApproved;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private Collection<TenderDetails> tenderDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private Collection<TenderBranch> tenderBranchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private Collection<PurchaseOrderMst> purchaseOrderMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private Collection<QuotationDetails> quotationDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private Collection<QuotationMst> quotationMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tenderId")
    private Collection<EmdIssue> emdIssueCollection;

    public TenderMst() {
    }

    public TenderMst(Integer id) {
        this.id = id;
    }

    public TenderMst(Integer id, Date pubDate, String pubDesc, Date submittedDate, double emd, double docCost, Date deadlineDate, Date deadlineTime, Date openingDate, String pressNoteLoc, boolean isApproved) {
        this.id = id;
        this.pubDate = pubDate;
        this.pubDesc = pubDesc;
        this.submittedDate = submittedDate;
        this.emd = emd;
        this.docCost = docCost;
        this.deadlineDate = deadlineDate;
        this.deadlineTime = deadlineTime;
        this.openingDate = openingDate;
        this.pressNoteLoc = pressNoteLoc;
        this.isApproved = isApproved;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getPubDesc() {
        return pubDesc;
    }

    public void setPubDesc(String pubDesc) {
        this.pubDesc = pubDesc;
    }

    public Date getSubmittedDate() {
        return submittedDate;
    }

    public void setSubmittedDate(Date submittedDate) {
        this.submittedDate = submittedDate;
    }

    public double getEmd() {
        return emd;
    }

    public void setEmd(double emd) {
        this.emd = emd;
    }

    public double getDocCost() {
        return docCost;
    }

    public void setDocCost(double docCost) {
        this.docCost = docCost;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(Date deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getPressNoteLoc() {
        return pressNoteLoc;
    }

    public void setPressNoteLoc(String pressNoteLoc) {
        this.pressNoteLoc = pressNoteLoc;
    }

    public boolean getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    @XmlTransient
    public Collection<TenderDetails> getTenderDetailsCollection() {
        return tenderDetailsCollection;
    }

    public void setTenderDetailsCollection(Collection<TenderDetails> tenderDetailsCollection) {
        this.tenderDetailsCollection = tenderDetailsCollection;
    }

    @XmlTransient
    public Collection<TenderBranch> getTenderBranchCollection() {
        return tenderBranchCollection;
    }

    public void setTenderBranchCollection(Collection<TenderBranch> tenderBranchCollection) {
        this.tenderBranchCollection = tenderBranchCollection;
    }

    @XmlTransient
    public Collection<PurchaseOrderMst> getPurchaseOrderMstCollection() {
        return purchaseOrderMstCollection;
    }

    public void setPurchaseOrderMstCollection(Collection<PurchaseOrderMst> purchaseOrderMstCollection) {
        this.purchaseOrderMstCollection = purchaseOrderMstCollection;
    }

    @XmlTransient
    public Collection<QuotationDetails> getQuotationDetailsCollection() {
        return quotationDetailsCollection;
    }

    public void setQuotationDetailsCollection(Collection<QuotationDetails> quotationDetailsCollection) {
        this.quotationDetailsCollection = quotationDetailsCollection;
    }

    @XmlTransient
    public Collection<QuotationMst> getQuotationMstCollection() {
        return quotationMstCollection;
    }

    public void setQuotationMstCollection(Collection<QuotationMst> quotationMstCollection) {
        this.quotationMstCollection = quotationMstCollection;
    }

    @XmlTransient
    public Collection<EmdIssue> getEmdIssueCollection() {
        return emdIssueCollection;
    }

    public void setEmdIssueCollection(Collection<EmdIssue> emdIssueCollection) {
        this.emdIssueCollection = emdIssueCollection;
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
        if (!(object instanceof TenderMst)) {
            return false;
        }
        TenderMst other = (TenderMst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TenderMst[ id=" + id + " ]";
    }
    
}
