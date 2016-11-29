/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import beans.StoreManagerLocal;
import entity.CompanyMst;
import entity.ItemMst;
import entity.StockMst;
import entity.TenderBranch;
import entity.TenderDetails;
import entity.TenderMst;
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
@WebService(serviceName = "StoreManagerWS")
@Stateless()
public class StoreManagerWS {
    @EJB
    private StoreManagerLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addNewCompany")
    @Oneway
    public void addNewCompany(@WebParam(name = "name") String name) {
        ejbRef.addNewCompany(name);
    }

    @WebMethod(operationName = "updateCompany")
    @Oneway
    public void updateCompany(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name, @WebParam(name = "isActive") Boolean isActive) {
        ejbRef.updateCompany(id, name, isActive);
    }

    @WebMethod(operationName = "removeCompany")
    @Oneway
    public void removeCompany(@WebParam(name = "id") Integer id) {
        ejbRef.removeCompany(id);
    }

    @WebMethod(operationName = "getCompanyDetailsById")
    public CompanyMst getCompanyDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getCompanyDetailsById(id);
    }

    @WebMethod(operationName = "getAllCompany")
    public Collection<CompanyMst> getAllCompany() {
        return ejbRef.getAllCompany();
    }

    @WebMethod(operationName = "addNewItem")
    @Oneway
    public void addNewItem(@WebParam(name = "name") String name, @WebParam(name = "companyId") Integer companyId) {
        ejbRef.addNewItem(name, companyId);
    }

    @WebMethod(operationName = "updateItem")
    @Oneway
    public void updateItem(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name, @WebParam(name = "companyId") Integer companyId) {
        ejbRef.updateItem(id, name, companyId);
    }

    @WebMethod(operationName = "removeItem")
    @Oneway
    public void removeItem(@WebParam(name = "id") Integer id) {
        ejbRef.removeItem(id);
    }

    @WebMethod(operationName = "getItemDetailsById")
    public ItemMst getItemDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getItemDetailsById(id);
    }

    @WebMethod(operationName = "getAllItem")
    public Collection<ItemMst> getAllItem() {
        return ejbRef.getAllItem();
    }

    @WebMethod(operationName = "addNewStock")
    @Oneway
    public void addNewStock(@WebParam(name = "finYear") String finYear, @WebParam(name = "itemId") Integer itemId, @WebParam(name = "asOnDate") Date asOnDate, @WebParam(name = "openingQty") Integer openingQty, @WebParam(name = "closingQty") Integer closingQty, @WebParam(name = "minQty") Integer minQty, @WebParam(name = "maxQty") Integer maxQty, @WebParam(name = "rate") Double rate) {
        ejbRef.addNewStock(finYear, itemId, asOnDate, openingQty, closingQty, minQty, maxQty, rate);
    }

    @WebMethod(operationName = "updateStock")
    @Oneway
    public void updateStock(@WebParam(name = "id") Integer id, @WebParam(name = "finYear") String finYear, @WebParam(name = "itemId") Integer itemId, @WebParam(name = "asOnDate") Date asOnDate, @WebParam(name = "openingQty") Integer openingQty, @WebParam(name = "closingQty") Integer closingQty, @WebParam(name = "minQty") Integer minQty, @WebParam(name = "maxQty") Integer maxQty, @WebParam(name = "rate") Double rate) {
        ejbRef.updateStock(id, finYear, itemId, asOnDate, openingQty, closingQty, minQty, maxQty, rate);
    }

    @WebMethod(operationName = "removeStock")
    @Oneway
    public void removeStock(@WebParam(name = "id") Integer id) {
        ejbRef.removeStock(id);
    }

    @WebMethod(operationName = "getStockDetailsById")
    public StockMst getStockDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getStockDetailsById(id);
    }

    @WebMethod(operationName = "getAllStock")
    public Collection<StockMst> getAllStock() {
        return ejbRef.getAllStock();
    }

    @WebMethod(operationName = "addNewTender")
    @Oneway
    public void addNewTender(@WebParam(name = "pubDate") Date pubDate, @WebParam(name = "pubDesc") String pubDesc, @WebParam(name = "submittedDate") Date submittedDate, @WebParam(name = "emd") double emd, @WebParam(name = "docCost") double docCost, @WebParam(name = "deadlineDate") Date deadlineDate, @WebParam(name = "deadlineTime") Date deadlineTime, @WebParam(name = "openingDate") Date openingDate, @WebParam(name = "pressNoteLoc") String pressNoteLoc, @WebParam(name = "isApproved") Boolean isApproved) {
        ejbRef.addNewTender(pubDate, pubDesc, submittedDate, emd, docCost, deadlineDate, deadlineTime, openingDate, pressNoteLoc, isApproved);
    }

    @WebMethod(operationName = "updateTender")
    @Oneway
    public void updateTender(@WebParam(name = "id") Integer id, @WebParam(name = "pubDate") Date pubDate, @WebParam(name = "pubDesc") String pubDesc, @WebParam(name = "submittedDate") Date submittedDate, @WebParam(name = "emd") double emd, @WebParam(name = "docCost") double docCost, @WebParam(name = "deadlineDate") Date deadlineDate, @WebParam(name = "deadlineTime") Date deadlineTime, @WebParam(name = "openingDate") Date openingDate, @WebParam(name = "pressNoteLoc") String pressNoteLoc, @WebParam(name = "isApproved") Boolean isApproved) {
        ejbRef.updateTender(id, pubDate, pubDesc, submittedDate, emd, docCost, deadlineDate, deadlineTime, openingDate, pressNoteLoc, isApproved);
    }

    @WebMethod(operationName = "removeTender")
    @Oneway
    public void removeTender(@WebParam(name = "id") Integer id) {
        ejbRef.removeTender(id);
    }

    @WebMethod(operationName = "getTenderDetailsById")
    public TenderMst getTenderDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getTenderDetailsById(id);
    }

    @WebMethod(operationName = "getAllTender")
    public Collection<TenderMst> getAllTender() {
        return ejbRef.getAllTender();
    }

    @WebMethod(operationName = "addNewTenderDetails")
    @Oneway
    public void addNewTenderDetails(@WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "itemId") Integer itemId, @WebParam(name = "qty") Integer qty, @WebParam(name = "remark") String remark) {
        ejbRef.addNewTenderDetails(tenderId, itemId, qty, remark);
    }

    @WebMethod(operationName = "updateTenderDetails")
    @Oneway
    public void updateTenderDetails(@WebParam(name = "id") Integer id, @WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "itemId") Integer itemId, @WebParam(name = "qty") Integer qty, @WebParam(name = "remark") String remark) {
        ejbRef.updateTenderDetails(id, tenderId, itemId, qty, remark);
    }

    @WebMethod(operationName = "removeTenderDetails")
    @Oneway
    public void removeTenderDetails(@WebParam(name = "id") Integer id) {
        ejbRef.removeTenderDetails(id);
    }

    @WebMethod(operationName = "getTenderDetailsDetailsById")
    public TenderDetails getTenderDetailsDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getTenderDetailsDetailsById(id);
    }

    @WebMethod(operationName = "getAllTenderDetails")
    public Collection<TenderDetails> getAllTenderDetails() {
        return ejbRef.getAllTenderDetails();
    }

    @WebMethod(operationName = "addNewTenderBranch")
    @Oneway
    public void addNewTenderBranch(@WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "branchId") Integer branchId) {
        ejbRef.addNewTenderBranch(tenderId, branchId);
    }

    @WebMethod(operationName = "updateTenderBranch")
    @Oneway
    public void updateTenderBranch(@WebParam(name = "id") Integer id, @WebParam(name = "tenderId") Integer tenderId, @WebParam(name = "branchId") Integer branchId) {
        ejbRef.updateTenderBranch(id, tenderId, branchId);
    }

    @WebMethod(operationName = "removeTenderBranch")
    @Oneway
    public void removeTenderBranch(@WebParam(name = "id") Integer id) {
        ejbRef.removeTenderBranch(id);
    }

    @WebMethod(operationName = "getTenderBranchDetailsById")
    public TenderBranch getTenderBranchDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getTenderBranchDetailsById(id);
    }

    @WebMethod(operationName = "getAllTenderBranch")
    public Collection<TenderBranch> getAllTenderBranch() {
        return ejbRef.getAllTenderBranch();
    }
    
}
