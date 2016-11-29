/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entity.*;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Priyanka
 */
@Local
public interface SupplierClientLocal {
    // Manage Supplier
    void newSupplierRegistration(String companyName, String personName, String address, String city, String state, String zipCode, String contactNo, String mobileNo, String faxNo, String emailId, String password, String website, String gstNo, Date gstDate, String cstNo, Date cstDate, String tinNo, Date tinDate, String companyDesc, Boolean isActive, Boolean isOnline);
    void updateSupplier(Integer id, String companyName, String personName, String address, String city, String state, String zipCode, String contactNo, String mobileNo, String faxNo, String emailId, String password, String website, String gstNo, Date gstDate, String cstNo, Date cstDate, String tinNo, Date tinDate, String companyDesc, Boolean isActive, Boolean isOnline);
    void removeSupplier(Integer id);
    Supplier getSupplierDetailsById(Integer id);
    Collection<Supplier> getAllSupplier();

    // Manage EMD
    void newEMDRegistration(Integer tenderId, Integer supplierId, Date issuedDate, double emdAmount, String emdBy, String chequeNo, String chequeDate, Boolean isApproved);
    void updateEMD(Integer id, Integer tenderId, Integer supplierId, Date issuedDate, double emdAmount, String emdBy, String chequeNo, String chequeDate, Boolean isApproved);
    void removeEMD(Integer id);
    EmdIssue getEMDDetailsById(Integer id);
    Collection<EmdIssue> getAllEMD();
    
    // Manage Quotation
    void addNewQuotation(Integer tenderId, Date qDate, Integer supplierId, String remark);
    void updateQuotation(Integer id, Integer tenderId, Date qDate, Integer supplierId, String remark);
    void removeQuotation(Integer id);
    QuotationMst getQuotationDetailsById(Integer id);
    Collection<QuotationMst> getAllQuotation();
    
    void addNewQuotationDetails(Integer quotationId, Integer tenderId, Integer itemId, Integer unitWiseQty, double unitWisePrice, Integer companyId, String remark, Boolean isIssued, String itemQty);
    void updateQuotationDetails(Integer id, Integer quotationId, Integer tenderId, Integer itemId, Integer unitWiseQty, double unitWisePrice, Integer companyId, String remark, Boolean isIssued, String itemQty);
    void removeQuotationDetails(Integer id);
    QuotationDetails getQuotationDetailsDetailsById(Integer id);
    Collection<QuotationDetails> getAllQuotationDetails();
}
