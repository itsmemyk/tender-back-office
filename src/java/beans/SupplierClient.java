/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entity.*;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Priyanka
 */
@Stateless
public class SupplierClient implements SupplierClientLocal {

    @PersistenceContext(unitName = "TenderModulePU")
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void newSupplierRegistration(String companyName, String personName, String address, String city, String state, String zipCode, String contactNo, String mobileNo, String faxNo, String emailId, String password, String website, String gstNo, Date gstDate, String cstNo, Date cstDate, String tinNo, Date tinDate, String companyDesc, Boolean isActive, Boolean isOnline) {
        Supplier s = new Supplier();
        s.setCompanyName(companyName);
        s.setPersonName(personName);
        s.setAddress(address);
        s.setCity(city);
        s.setState(state);
        s.setZipcode(zipCode);
        s.setContactNo(contactNo);
        s.setMobileNo(mobileNo);
        s.setFaxNo(faxNo);
        s.setEmailId(emailId);
        s.setPassword(password);
        s.setWebsite(website);
        s.setGstNo(gstNo);
        s.setGstDate(gstDate);
        s.setCstNo(cstNo);
        s.setCstDate(cstDate);
        s.setTinNo(tinNo);
        s.setTinDate(tinDate);        
        s.setCompanyDesc(companyDesc);
        s.setIsActive(isActive);
        s.setIsOnline(isOnline);
        em.persist((s));
    }

    @Override
    public void updateSupplier(Integer id, String companyName, String personName, String address, String city, String state, String zipCode, String contactNo, String mobileNo, String faxNo, String emailId, String password, String website, String gstNo, Date gstDate, String cstNo, Date cstDate, String tinNo, Date tinDate, String companyDesc, Boolean isActive, Boolean isOnline) {
        Supplier s = this.getSupplierDetailsById(id);
        s.setCompanyName(companyName);
        s.setPersonName(personName);
        s.setAddress(address);
        s.setCity(city);
        s.setState(state);
        s.setZipcode(zipCode);
        s.setContactNo(contactNo);
        s.setMobileNo(mobileNo);
        s.setFaxNo(faxNo);
        s.setEmailId(emailId);
        s.setPassword(password);
        s.setWebsite(website);
        s.setGstNo(gstNo);
        s.setGstDate(gstDate);
        s.setCstNo(cstNo);
        s.setCstDate(cstDate);
        s.setTinNo(tinNo);
        s.setTinDate(tinDate);        
        s.setCompanyDesc(companyDesc);
        s.setIsActive(isActive);
        s.setIsOnline(isOnline);
        em.merge((s));
    }

    @Override
    public void removeSupploer(Integer id) {
        Supplier s = this.getSupplierDetailsById(id);
        em.remove(s);
    }

    @Override
    public Supplier getSupplierDetailsById(Integer id) {
        return em.find(Supplier.class, id);
    }

    @Override
    public Collection<Supplier> getAllSupplier() {
        return em.createNamedQuery("Supplier.findAll", Supplier.class).getResultList();
    }

}
