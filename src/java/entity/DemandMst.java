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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mayank
 */
@Entity
@Table(name = "demand_mst")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DemandMst.findAll", query = "SELECT d FROM DemandMst d"),
    @NamedQuery(name = "DemandMst.findById", query = "SELECT d FROM DemandMst d WHERE d.id = :id"),
    @NamedQuery(name = "DemandMst.findByFinYear", query = "SELECT d FROM DemandMst d WHERE d.finYear = :finYear"),
    @NamedQuery(name = "DemandMst.findByDemandDate", query = "SELECT d FROM DemandMst d WHERE d.demandDate = :demandDate")})
public class DemandMst implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fin_year")
    private String finYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "demand_date")
    @Temporal(TemporalType.DATE)
    private Date demandDate;
    @JoinColumn(name = "emp_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User empId;
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Department deptId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "demandId")
    private Collection<DemandDetails> demandDetailsCollection;

    public DemandMst() {
    }

    public DemandMst(Integer id) {
        this.id = id;
    }

    public DemandMst(Integer id, String finYear, Date demandDate) {
        this.id = id;
        this.finYear = finYear;
        this.demandDate = demandDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFinYear() {
        return finYear;
    }

    public void setFinYear(String finYear) {
        this.finYear = finYear;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public void setDemandDate(Date demandDate) {
        this.demandDate = demandDate;
    }

    public User getEmpId() {
        return empId;
    }

    public void setEmpId(User empId) {
        this.empId = empId;
    }

    public Department getDeptId() {
        return deptId;
    }

    public void setDeptId(Department deptId) {
        this.deptId = deptId;
    }

    @XmlTransient
    public Collection<DemandDetails> getDemandDetailsCollection() {
        return demandDetailsCollection;
    }

    public void setDemandDetailsCollection(Collection<DemandDetails> demandDetailsCollection) {
        this.demandDetailsCollection = demandDetailsCollection;
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
        if (!(object instanceof DemandMst)) {
            return false;
        }
        DemandMst other = (DemandMst) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.DemandMst[ id=" + id + " ]";
    }
    
}
