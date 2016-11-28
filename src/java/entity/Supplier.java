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
@Table(name = "supplier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Supplier.findAll", query = "SELECT s FROM Supplier s"),
    @NamedQuery(name = "Supplier.findById", query = "SELECT s FROM Supplier s WHERE s.id = :id"),
    @NamedQuery(name = "Supplier.findByCompanyName", query = "SELECT s FROM Supplier s WHERE s.companyName = :companyName"),
    @NamedQuery(name = "Supplier.findByPersonName", query = "SELECT s FROM Supplier s WHERE s.personName = :personName"),
    @NamedQuery(name = "Supplier.findByCity", query = "SELECT s FROM Supplier s WHERE s.city = :city"),
    @NamedQuery(name = "Supplier.findByState", query = "SELECT s FROM Supplier s WHERE s.state = :state"),
    @NamedQuery(name = "Supplier.findByZipcode", query = "SELECT s FROM Supplier s WHERE s.zipcode = :zipcode"),
    @NamedQuery(name = "Supplier.findByContactNo", query = "SELECT s FROM Supplier s WHERE s.contactNo = :contactNo"),
    @NamedQuery(name = "Supplier.findByMobileNo", query = "SELECT s FROM Supplier s WHERE s.mobileNo = :mobileNo"),
    @NamedQuery(name = "Supplier.findByFaxNo", query = "SELECT s FROM Supplier s WHERE s.faxNo = :faxNo"),
    @NamedQuery(name = "Supplier.findByEmailId", query = "SELECT s FROM Supplier s WHERE s.emailId = :emailId"),
    @NamedQuery(name = "Supplier.findByWebsite", query = "SELECT s FROM Supplier s WHERE s.website = :website"),
    @NamedQuery(name = "Supplier.findByGstNo", query = "SELECT s FROM Supplier s WHERE s.gstNo = :gstNo"),
    @NamedQuery(name = "Supplier.findByGstDate", query = "SELECT s FROM Supplier s WHERE s.gstDate = :gstDate"),
    @NamedQuery(name = "Supplier.findByCstNo", query = "SELECT s FROM Supplier s WHERE s.cstNo = :cstNo"),
    @NamedQuery(name = "Supplier.findByCstDate", query = "SELECT s FROM Supplier s WHERE s.cstDate = :cstDate"),
    @NamedQuery(name = "Supplier.findByTinNo", query = "SELECT s FROM Supplier s WHERE s.tinNo = :tinNo"),
    @NamedQuery(name = "Supplier.findByTinDate", query = "SELECT s FROM Supplier s WHERE s.tinDate = :tinDate"),
    @NamedQuery(name = "Supplier.findByIsActive", query = "SELECT s FROM Supplier s WHERE s.isActive = :isActive"),
    @NamedQuery(name = "Supplier.findByPassword", query = "SELECT s FROM Supplier s WHERE s.password = :password"),
    @NamedQuery(name = "Supplier.findByIsOnline", query = "SELECT s FROM Supplier s WHERE s.isOnline = :isOnline")})
public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "company_name")
    private String companyName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "person_name")
    private String personName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "zipcode")
    private String zipcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contact_no")
    private String contactNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mobile_no")
    private String mobileNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fax_no")
    private String faxNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "email_id")
    private String emailId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "gst_no")
    private String gstNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "gst_date")
    @Temporal(TemporalType.DATE)
    private Date gstDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cst_no")
    private String cstNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cst_date")
    @Temporal(TemporalType.DATE)
    private Date cstDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "tin_no")
    private String tinNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tin_date")
    @Temporal(TemporalType.DATE)
    private Date tinDate;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "company_desc")
    private String companyDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_active")
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_online")
    private boolean isOnline;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    private Collection<PurchaseOrderMst> purchaseOrderMstCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    private Collection<DemandDetails> demandDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplierId")
    private Collection<EmdIssue> emdIssueCollection;

    public Supplier() {
    }

    public Supplier(Integer id) {
        this.id = id;
    }

    public Supplier(Integer id, String companyName, String personName, String address, String city, String state, String zipcode, String contactNo, String mobileNo, String faxNo, String emailId, String website, String gstNo, Date gstDate, String cstNo, Date cstDate, String tinNo, Date tinDate, String companyDesc, boolean isActive, String password, boolean isOnline) {
        this.id = id;
        this.companyName = companyName;
        this.personName = personName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.contactNo = contactNo;
        this.mobileNo = mobileNo;
        this.faxNo = faxNo;
        this.emailId = emailId;
        this.website = website;
        this.gstNo = gstNo;
        this.gstDate = gstDate;
        this.cstNo = cstNo;
        this.cstDate = cstDate;
        this.tinNo = tinNo;
        this.tinDate = tinDate;
        this.companyDesc = companyDesc;
        this.isActive = isActive;
        this.password = password;
        this.isOnline = isOnline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getFaxNo() {
        return faxNo;
    }

    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public Date getGstDate() {
        return gstDate;
    }

    public void setGstDate(Date gstDate) {
        this.gstDate = gstDate;
    }

    public String getCstNo() {
        return cstNo;
    }

    public void setCstNo(String cstNo) {
        this.cstNo = cstNo;
    }

    public Date getCstDate() {
        return cstDate;
    }

    public void setCstDate(Date cstDate) {
        this.cstDate = cstDate;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public Date getTinDate() {
        return tinDate;
    }

    public void setTinDate(Date tinDate) {
        this.tinDate = tinDate;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    @XmlTransient
    public Collection<PurchaseOrderMst> getPurchaseOrderMstCollection() {
        return purchaseOrderMstCollection;
    }

    public void setPurchaseOrderMstCollection(Collection<PurchaseOrderMst> purchaseOrderMstCollection) {
        this.purchaseOrderMstCollection = purchaseOrderMstCollection;
    }

    @XmlTransient
    public Collection<DemandDetails> getDemandDetailsCollection() {
        return demandDetailsCollection;
    }

    public void setDemandDetailsCollection(Collection<DemandDetails> demandDetailsCollection) {
        this.demandDetailsCollection = demandDetailsCollection;
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
        if (!(object instanceof Supplier)) {
            return false;
        }
        Supplier other = (Supplier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Supplier[ id=" + id + " ]";
    }
    
}
