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
public interface StoreManagerLocal {
    // manage Company Master
    void addNewCompany(String name);
    void updateCompany(Integer id, String name, Boolean isActive);
    void removeCompany(Integer id);
    CompanyMst getCompanyDetailsById(Integer id);
    Collection<CompanyMst> getAllCompany();
    
    // manage Item Master
    void addNewItem(String name, Integer companyId);
    void updateItem(Integer id, String name, Integer companyId);
    void removeItem(Integer id);
    ItemMst getItemDetailsById(Integer id);
    Collection<ItemMst> getAllItem();
    
    void addNewStock(String finYear, Integer itemId, Date asOnDate, Integer openingQty, Integer closingQty, Integer minQty, Integer maxQty, Double rate);
    void updateStock(Integer id, String finYear, Integer itemId, Date asOnDate, Integer openingQty, Integer closingQty, Integer minQty, Integer maxQty, Double rate);
    void removeStock(Integer id);
    StockMst getStockDetailsById(Integer id);
    Collection<StockMst> getAllStock();
    
    // manage tenders
    void addNewTender(Date pubDate, String pubDesc, Date submittedDate, double emd, double docCost, Date deadlineDate, Date deadlineTime, Date openingDate, String pressNoteLoc, Boolean isApproved);
    void updateTender(Integer id, Date pubDate, String pubDesc, Date submittedDate, double emd, double docCost, Date deadlineDate, Date deadlineTime, Date openingDate, String pressNoteLoc, Boolean isApproved);
    void removeTender(Integer id);
    TenderMst getTenderDetailsById(Integer id);
    Collection<TenderMst> getAllTender();
    
    void addNewTenderDetails(Integer tenderId, Integer itemId, Integer qty, String remark);
    void updateTenderDetails(Integer id, Integer tenderId, Integer itemId, Integer qty, String remark);
    void removeTenderDetails(Integer id);
    TenderDetails getTenderDetailsDetailsById(Integer id);
    Collection<TenderDetails> getAllTenderDetails();
    
    void addNewTenderBranch(Integer tenderId, Integer branchId);
    void updateTenderBranch(Integer id, Integer tenderId, Integer branchId);
    void removeTenderBranch(Integer id);
    TenderBranch getTenderBranchDetailsById(Integer id);
    Collection<TenderBranch> getAllTenderBranch();
}
