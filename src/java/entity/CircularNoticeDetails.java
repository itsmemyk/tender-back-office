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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "circular_notice_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CircularNoticeDetails.findAll", query = "SELECT c FROM CircularNoticeDetails c"),
    @NamedQuery(name = "CircularNoticeDetails.findById", query = "SELECT c FROM CircularNoticeDetails c WHERE c.id = :id"),
    @NamedQuery(name = "CircularNoticeDetails.findByIsRead", query = "SELECT c FROM CircularNoticeDetails c WHERE c.isRead = :isRead"),
    @NamedQuery(name = "CircularNoticeDetails.findByReadDate", query = "SELECT c FROM CircularNoticeDetails c WHERE c.readDate = :readDate")})
public class CircularNoticeDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_read")
    private boolean isRead;
    @Basic(optional = false)
    @NotNull
    @Column(name = "read_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readDate;
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User empId;
    @JoinColumn(name = "circular_notice_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CircularNotice circularNoticeId;

    public CircularNoticeDetails() {
    }

    public CircularNoticeDetails(Integer id) {
        this.id = id;
    }

    public CircularNoticeDetails(Integer id, boolean isRead, Date readDate) {
        this.id = id;
        this.isRead = isRead;
        this.readDate = readDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public Date getReadDate() {
        return readDate;
    }

    public void setReadDate(Date readDate) {
        this.readDate = readDate;
    }

    public User getEmpId() {
        return empId;
    }

    public void setEmpId(User empId) {
        this.empId = empId;
    }

    public CircularNotice getCircularNoticeId() {
        return circularNoticeId;
    }

    public void setCircularNoticeId(CircularNotice circularNoticeId) {
        this.circularNoticeId = circularNoticeId;
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
        if (!(object instanceof CircularNoticeDetails)) {
            return false;
        }
        CircularNoticeDetails other = (CircularNoticeDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CircularNoticeDetails[ id=" + id + " ]";
    }
    
}
