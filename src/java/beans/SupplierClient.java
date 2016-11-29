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
    public void removeSupplier(Integer id) {
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

    @Override
    public void newEMDRegistration(Integer tenderId, Integer supplierId, Date issuedDate, double emdAmount, String emdBy, String chequeNo, String chequeDate, Boolean isApproved) {
        Collection<EmdIssue> emdCollections;
        TenderMst tender = em.find(TenderMst.class, tenderId);
        Supplier supp = em.find(Supplier.class, supplierId);
        
        EmdIssue emd = new EmdIssue();
        emd.setTenderId(tender);
        emd.setSupplierId(supp);
        emd.setIssuedDate(issuedDate);
        emd.setEmdAmount(emdAmount);
        emd.setEmdBy(emdBy);
        emd.setChequeDate(chequeDate);
        emd.setChequeNo(chequeNo);
        emd.setIsApproved(isApproved);
        em.persist(emd);
        
        emdCollections = tender.getEmdIssueCollection();
        if(!emdCollections.contains(emd)) {
            emdCollections.add(emd);
            tender.setEmdIssueCollection(emdCollections);
            em.merge(tender);
        }
        emdCollections = supp.getEmdIssueCollection();
        if(!emdCollections.contains(emd)) {
            emdCollections.add(emd);
            supp.setEmdIssueCollection(emdCollections);
            em.merge(supp);
        }
    }

    @Override
    public void updateEMD(Integer id, Integer tenderId, Integer supplierId, Date issuedDate, double emdAmount, String emdBy, String chequeNo, String chequeDate, Boolean isApproved) {
        Collection<EmdIssue> emdCollections;
        TenderMst tender = em.find(TenderMst.class, tenderId);
        Supplier supp = em.find(Supplier.class, supplierId);
        
        EmdIssue emd = this.getEMDDetailsById(id);
        emd.setTenderId(tender);
        emd.setSupplierId(supp);
        emd.setIssuedDate(issuedDate);
        emd.setEmdAmount(emdAmount);
        emd.setEmdBy(emdBy);
        emd.setChequeDate(chequeDate);
        emd.setChequeNo(chequeNo);
        emd.setIsApproved(isApproved);
        
        emdCollections = tender.getEmdIssueCollection();
        if(!emdCollections.contains(emd)) {
            emdCollections.add(emd);
            tender.setEmdIssueCollection(emdCollections);
            em.merge(tender);
        }
        emdCollections = supp.getEmdIssueCollection();
        if(!emdCollections.contains(emd)) {
            emdCollections.add(emd);
            supp.setEmdIssueCollection(emdCollections);
            em.merge(supp);
        }        
        em.merge(emd);
    }

    @Override
    public void removeEMD(Integer id) {
        em.remove(this.getEMDDetailsById(id));
    }

    @Override
    public EmdIssue getEMDDetailsById(Integer id) {
        return em.find(EmdIssue.class, id);
    }

    @Override
    public Collection<EmdIssue> getAllEMD() {
        return em.createNamedQuery("EmdIssue.findAll", EmdIssue.class).getResultList();
    }

    @Override
    public void addNewQuotation(Integer tenderId, Date qDate, Integer supplierId, String remark) {
        Collection<QuotationMst> qqCollections;
        Supplier supp = em.find(Supplier.class, supplierId);
        TenderMst tender = em.find(TenderMst.class, tenderId);
        
        QuotationMst qq = new QuotationMst();
        qq.setQDate(qDate);
        qq.setRemark(remark);
        qq.setTenderId(tender);
        qq.setSupplierId(supp);
        
        em.persist(qq);
        
        qqCollections = supp.getQuotationMstCollection();
        if(!qqCollections.contains(qq)) {
            qqCollections.add(qq);
            supp.setQuotationMstCollection(qqCollections);
            em.merge(supp);
        }
        qqCollections = tender.getQuotationMstCollection();
        if(!qqCollections.contains(qq)) {
            qqCollections.add(qq);
            tender.setQuotationMstCollection(qqCollections);
            em.merge(tender);
        }
    }

    @Override
    public void updateQuotation(Integer id, Integer tenderId, Date qDate, Integer supplierId, String remark) {
        Collection<QuotationMst> qqCollections;
        Supplier supp = em.find(Supplier.class, supplierId);
        TenderMst tender = em.find(TenderMst.class, tenderId);
        
        QuotationMst qq = this.getQuotationDetailsById(id);
        qq.setQDate(qDate);
        qq.setRemark(remark);
        qq.setTenderId(tender);
        qq.setSupplierId(supp);        
        
        qqCollections = supp.getQuotationMstCollection();
        if(!qqCollections.contains(qq)) {
            qqCollections.add(qq);
            supp.setQuotationMstCollection(qqCollections);
            em.merge(supp);
        }
        qqCollections = tender.getQuotationMstCollection();
        if(!qqCollections.contains(qq)) {
            qqCollections.add(qq);
            tender.setQuotationMstCollection(qqCollections);
            em.merge(tender);
        }
        em.merge(qq);
    }

    @Override
    public void removeQuotation(Integer id) {
        em.remove(this.getQuotationDetailsById(id));
    }

    @Override
    public QuotationMst getQuotationDetailsById(Integer id) {
        return em.find(QuotationMst.class, id);
    }

    @Override
    public Collection<QuotationMst> getAllQuotation() {
        return em.createNamedQuery("QuotationMst.findAll", QuotationMst.class).getResultList();
    }

    @Override
    public void addNewQuotationDetails(Integer quotationId, Integer tenderId, Integer itemId, Integer unitWiseQty, double unitWisePrice, Integer companyId, String remark, Boolean isIssued, String itemQty) {
        Collection<QuotationDetails> detailsCollection;
        CompanyMst com = em.find(CompanyMst.class, companyId);
        TenderMst tender = em.find(TenderMst.class, tenderId);
        QuotationMst qq = em.find(QuotationMst.class, quotationId);
        ItemMst item = em.find(ItemMst.class, itemId);
        
        QuotationDetails details = new QuotationDetails();
        details.setCompanyId(com);
        details.setQuotationId(qq);
        details.setTenderId(tender);
        details.setIsIssued(isIssued);
        details.setItemId(item);
        details.setItemQty(itemQty);
        details.setUnitWisePrice(unitWisePrice);
        details.setUnitWiseQty(unitWiseQty);
        details.setRemark(remark);
        details.setItemQty(itemQty);
        em.persist(details);
        
        detailsCollection = com.getQuotationDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            com.setQuotationDetailsCollection(detailsCollection);
            em.merge(com);
        }
        
        detailsCollection = tender.getQuotationDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            tender.setQuotationDetailsCollection(detailsCollection);
            em.merge(tender);
        }
        
        detailsCollection = qq.getQuotationDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            qq.setQuotationDetailsCollection(detailsCollection);
            em.merge(qq);
        }
        
        detailsCollection = item.getQuotationDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            item.setQuotationDetailsCollection(detailsCollection);
            em.merge(item);
        }
    }

    @Override
    public void updateQuotationDetails(Integer id, Integer quotationId, Integer tenderId, Integer itemId, Integer unitWiseQty, double unitWisePrice, Integer companyId, String remark, Boolean isIssued, String itemQty) {
        Collection<QuotationDetails> detailsCollection;
        CompanyMst com = em.find(CompanyMst.class, companyId);
        TenderMst tender = em.find(TenderMst.class, tenderId);
        QuotationMst qq = em.find(QuotationMst.class, quotationId);
        ItemMst item = em.find(ItemMst.class, itemId);
        
        QuotationDetails details = this.getQuotationDetailsDetailsById(id);
        details.setCompanyId(com);
        details.setQuotationId(qq);
        details.setTenderId(tender);
        details.setIsIssued(isIssued);
        details.setItemId(item);
        details.setItemQty(itemQty);
        details.setUnitWisePrice(unitWisePrice);
        details.setUnitWiseQty(unitWiseQty);
        details.setRemark(remark);
        details.setItemQty(itemQty);
        
        detailsCollection = com.getQuotationDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            com.setQuotationDetailsCollection(detailsCollection);
            em.merge(com);
        }
        
        detailsCollection = tender.getQuotationDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            tender.setQuotationDetailsCollection(detailsCollection);
            em.merge(tender);
        }
        
        detailsCollection = qq.getQuotationDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            qq.setQuotationDetailsCollection(detailsCollection);
            em.merge(qq);
        }
        
        detailsCollection = item.getQuotationDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            item.setQuotationDetailsCollection(detailsCollection);
            em.merge(item);
        }
        em.merge(details);
    }

    @Override
    public void removeQuotationDetails(Integer id) {
        em.remove(this.getQuotationDetailsDetailsById(id));
    }

    @Override
    public QuotationDetails getQuotationDetailsDetailsById(Integer id) {
        return em.find(QuotationDetails.class, id);
    }

    @Override
    public Collection<QuotationDetails> getAllQuotationDetails() {
        return em.createNamedQuery("QuotationDetails.findAll", QuotationDetails.class).getResultList();
    }

}
