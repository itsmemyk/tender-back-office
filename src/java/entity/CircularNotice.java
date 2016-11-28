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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "circular_notice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CircularNotice.findAll", query = "SELECT c FROM CircularNotice c"),
    @NamedQuery(name = "CircularNotice.findById", query = "SELECT c FROM CircularNotice c WHERE c.id = :id"),
    @NamedQuery(name = "CircularNotice.findByCirDate", query = "SELECT c FROM CircularNotice c WHERE c.cirDate = :cirDate"),
    @NamedQuery(name = "CircularNotice.findByFromDate", query = "SELECT c FROM CircularNotice c WHERE c.fromDate = :fromDate"),
    @NamedQuery(name = "CircularNotice.findByToDate", query = "SELECT c FROM CircularNotice c WHERE c.toDate = :toDate")})
public class CircularNotice implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cir_date")
    @Temporal(TemporalType.DATE)
    private Date cirDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "notice_desc")
    private String noticeDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "circularNoticeId")
    private Collection<CircularNoticeDetails> circularNoticeDetailsCollection;
    @JoinColumn(name = "view_dept_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Department viewDeptId;
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User empId;
    @JoinColumn(name = "view_designation_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Designation viewDesignationId;

    public CircularNotice() {
    }

    public CircularNotice(Integer id) {
        this.id = id;
    }

    public CircularNotice(Integer id, Date cirDate, String noticeDesc, Date fromDate, Date toDate) {
        this.id = id;
        this.cirDate = cirDate;
        this.noticeDesc = noticeDesc;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCirDate() {
        return cirDate;
    }

    public void setCirDate(Date cirDate) {
        this.cirDate = cirDate;
    }

    public String getNoticeDesc() {
        return noticeDesc;
    }

    public void setNoticeDesc(String noticeDesc) {
        this.noticeDesc = noticeDesc;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @XmlTransient
    public Collection<CircularNoticeDetails> getCircularNoticeDetailsCollection() {
        return circularNoticeDetailsCollection;
    }

    public void setCircularNoticeDetailsCollection(Collection<CircularNoticeDetails> circularNoticeDetailsCollection) {
        this.circularNoticeDetailsCollection = circularNoticeDetailsCollection;
    }

    public Department getViewDeptId() {
        return viewDeptId;
    }

    public void setViewDeptId(Department viewDeptId) {
        this.viewDeptId = viewDeptId;
    }

    public User getEmpId() {
        return empId;
    }

    public void setEmpId(User empId) {
        this.empId = empId;
    }

    public Designation getViewDesignationId() {
        return viewDesignationId;
    }

    public void setViewDesignationId(Designation viewDesignationId) {
        this.viewDesignationId = viewDesignationId;
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
        if (!(object instanceof CircularNotice)) {
            return false;
        }
        CircularNotice other = (CircularNotice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CircularNotice[ id=" + id + " ]";
    }
    
}
