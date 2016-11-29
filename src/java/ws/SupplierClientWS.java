/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import beans.SupplierClientLocal;
import entity.EmdIssue;
import entity.QuotationDetails;
import entity.QuotationMst;
import entity.Supplier;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mayank
 */
@WebService(serviceName = "SupplierClientWS")
@Stateless()
public class SupplierClientWS {
    @EJB
    private SupplierClientLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "newSupplierRegistration")
    @Oneway
    public void newSupplierRegistration(@WebParam(name = "companyName") String companyName, @WebParam(name = "personName") String personName, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "state") String state, @WebParam(name = "zipCode") String zipCode, @WebParam(name = "contactNo") String contactNo, @WebParam(name = "mobileNo") String mobileNo, @WebParam(name = "faxNo") String faxNo, @WebParam(name = "emailId") String emailId, @WebParam(name = "password") String password, @WebParam(name = "website") String website, @WebParam(name = "gstNo") String gstNo, @WebParam(name = "gstDate") Date gstDate, @WebParam(name = "cstNo") String cstNo, @WebParam(name = "cstDate") Date cstDate, @WebParam(name = "tinNo") String tinNo, @WebParam(name = "tinDate") Date tinDate, @WebParam(name = "companyDesc") String companyDesc, @WebParam(name = "isActive") Boolean isActive, @WebParam(name = "isOnline") Boolean isOnline) {
        ejbRef.newSupplierRegistration(companyName, personName, address, city, state, zipCode, contactNo, mobileNo, faxNo, emailId, password, website, gstNo, gstDate, cstNo, cstDate, tinNo, tinDate, companyDesc, isActive, isOnline);
    }

    @WebMethod(operationName = "updateSupplier")
    @Oneway
    public void updateSupplier(@WebParam(name = "id") Integer id, @WebParam(name = "companyName") String companyName, @WebParam(name = "personName") String personName, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "state") String state, @WebParam(name = "zipCode") String zipCode, @WebParam(name = "contactNo") String contactNo, @WebParam(name = "mobileNo") String mobileNo, @WebParam(name = "faxNo") String faxNo, @WebParam(name = "emailId") String emailId, @WebParam(name = "password") String password, @WebParam(name = "website") String website, @WebParam(name = "gstNo") String gstNo, @WebParam(name = "gstDate") Date gstDate, @WebParam(name = "cstNo") String cstNo, @WebParam(name = "cstDate") Date cstDate, @WebParam(name = "tinNo") String tinNo, @WebParam(name = "tinDate") Date tinDate, @WebParam(name = "companyDesc") String companyDesc, @WebParam(name = "isActive") Boolean isActive, @WebParam(name = "isOnline") Boolean isOnline) {
        ejbRef.updateSupplier(id, companyName, personName, address, city, state, zipCode, contactNo, mobileNo, faxNo, emailId, password, website, gstNo, gstDate, cstNo, cstDate, tinNo, tinDate, companyDesc, isActive, isOnline);
    }

    @WebMethod(operationName = "removeSupplier")
    @Oneway
    public void removeSupplier(@WebParam(name = "id") Integer id) {
        ejbRef.removeSupplier(id);
    }

    @WebMethod(operationName = "getSupplierDetailsById")
    public Supplier getSupplierDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getSupplierDetailsById(id);
    }

    @WebMethod(operationName = "getAllSupplier")
    public Collection<Supplier> getAllSupplier() {
        return ejbRef.getAllSupplier();
    }

    @WebMethod(operationName = "newEMDRegistration")
    @Oneway
    public void newEMDRegistration(@WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "supplierId") Integer supplierId, @WebParam(name = "issuedDate") Date issuedDate, @WebParam(name = "emdAmount") double emdAmount, @WebParam(name = "emdBy") String emdBy, @WebParam(name = "chequeNo") String chequeNo, @WebParam(name = "chequeDate") String chequeDate, @WebParam(name = "isApproved") Boolean isApproved) {
        ejbRef.newEMDRegistration(tenderId, supplierId, issuedDate, emdAmount, emdBy, chequeNo, chequeDate, isApproved);
    }

    @WebMethod(operationName = "updateEMD")
    @Oneway
    public void updateEMD(@WebParam(name = "id") Integer id, @WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "supplierId") Integer supplierId, @WebParam(name = "issuedDate") Date issuedDate, @WebParam(name = "emdAmount") double emdAmount, @WebParam(name = "emdBy") String emdBy, @WebParam(name = "chequeNo") String chequeNo, @WebParam(name = "chequeDate") String chequeDate, @WebParam(name = "isApproved") Boolean isApproved) {
        ejbRef.updateEMD(id, tenderId, supplierId, issuedDate, emdAmount, emdBy, chequeNo, chequeDate, isApproved);
    }

    @WebMethod(operationName = "removeEMD")
    @Oneway
    public void removeEMD(@WebParam(name = "id") Integer id) {
        ejbRef.removeEMD(id);
    }

    @WebMethod(operationName = "getEMDDetailsById")
    public EmdIssue getEMDDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getEMDDetailsById(id);
    }

    @WebMethod(operationName = "getAllEMD")
    public Collection<EmdIssue> getAllEMD() {
        return ejbRef.getAllEMD();
    }

    @WebMethod(operationName = "addNewQuotation")
    @Oneway
    public void addNewQuotation(@WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "qDate") Date qDate, @WebParam(name = "supplierId") Integer supplierId, @WebParam(name = "remark") String remark) {
        ejbRef.addNewQuotation(tenderId, qDate, supplierId, remark);
    }

    @WebMethod(operationName = "updateQuotation")
    @Oneway
    public void updateQuotation(@WebParam(name = "id") Integer id, @WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "qDate") Date qDate, @WebParam(name = "supplierId") Integer supplierId, @WebParam(name = "remark") String remark) {
        ejbRef.updateQuotation(id, tenderId, qDate, supplierId, remark);
    }

    @WebMethod(operationName = "removeQuotation")
    @Oneway
    public void removeQuotation(@WebParam(name = "id") Integer id) {
        ejbRef.removeQuotation(id);
    }

    @WebMethod(operationName = "getQuotationDetailsById")
    public QuotationMst getQuotationDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getQuotationDetailsById(id);
    }

    @WebMethod(operationName = "getAllQuotation")
    public Collection<QuotationMst> getAllQuotation() {
        return ejbRef.getAllQuotation();
    }

    @WebMethod(operationName = "addNewQuotationDetails")
    @Oneway
    public void addNewQuotationDetails(@WebParam(name = "quotationId") Integer quotationId, @WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "itemId") Integer itemId, @WebParam(name = "unitWiseQty") Integer unitWiseQty, @WebParam(name = "unitWisePrice") double unitWisePrice, @WebParam(name = "companyId") Integer companyId, @WebParam(name = "remark") String remark, @WebParam(name = "isIssued") Boolean isIssued, @WebParam(name = "itemQty") String itemQty) {
        ejbRef.addNewQuotationDetails(quotationId, tenderId, itemId, unitWiseQty, unitWisePrice, companyId, remark, isIssued, itemQty);
    }

    @WebMethod(operationName = "updateQuotationDetails")
    @Oneway
    public void updateQuotationDetails(@WebParam(name = "id") Integer id, @WebParam(name = "quotationId") Integer quotationId, @WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "itemId") Integer itemId, @WebParam(name = "unitWiseQty") Integer unitWiseQty, @WebParam(name = "unitWisePrice") double unitWisePrice, @WebParam(name = "companyId") Integer companyId, @WebParam(name = "remark") String remark, @WebParam(name = "isIssued") Boolean isIssued, @WebParam(name = "itemQty") String itemQty) {
        ejbRef.updateQuotationDetails(id, quotationId, tenderId, itemId, unitWiseQty, unitWisePrice, companyId, remark, isIssued, itemQty);
    }

    @WebMethod(operationName = "removeQuotationDetails")
    @Oneway
    public void removeQuotationDetails(@WebParam(name = "id") Integer id) {
        ejbRef.removeQuotationDetails(id);
    }

    @WebMethod(operationName = "getQuotationDetailsDetailsById")
    public QuotationDetails getQuotationDetailsDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getQuotationDetailsDetailsById(id);
    }

    @WebMethod(operationName = "getAllQuotationDetails")
    public Collection<QuotationDetails> getAllQuotationDetails() {
        return ejbRef.getAllQuotationDetails();
    }
    
}
