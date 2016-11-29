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
public class StoreManager implements StoreManagerLocal {

    @PersistenceContext(unitName = "TenderModulePU")
    EntityManager em;

    @Override
    public void addNewCompany(String name) {
        CompanyMst c = new CompanyMst();
        c.setName(name);
        c.setIsActive(true);
        em.persist(c);
    }

    @Override
    public void updateCompany(Integer id, String name, Boolean isActive) {
        CompanyMst c = this.getCompanyDetailsById(id);
        c.setName(name);
        c.setIsActive(true);
        em.merge(c);
    }

    @Override
    public void removeCompany(Integer id) {
        CompanyMst c = this.getCompanyDetailsById(id);
        em.remove(c);
    }

    @Override
    public CompanyMst getCompanyDetailsById(Integer id) {
        return em.find(CompanyMst.class, id);
    }

    @Override
    public Collection<CompanyMst> getAllCompany() {
        return em.createNamedQuery("CompanyMst.findAll", CompanyMst.class).getResultList();
    }
    
    @Override
    public void addNewItem(String name, Integer companyId) {
        CompanyMst com = this.getCompanyDetailsById(companyId);
        ItemMst c = new ItemMst();
        c.setName(name);
        c.setCompanyId(com);
        em.persist(c);
        
        Collection<ItemMst> items = com.getItemMstCollection();
        if (!items.contains(c)) {
            items.add(c);
            com.setItemMstCollection(items);
            em.merge(com);
        }
    }

    @Override
    public void updateItem(Integer id, String name, Integer companyId) {
        CompanyMst com = this.getCompanyDetailsById(companyId);
        ItemMst c = this.getItemDetailsById(id);
        c.setName(name);        
        if (c.getCompanyId().getId() != companyId) {
            Collection<ItemMst> items = com.getItemMstCollection();
            if (!items.contains(c)) {
                items.add(c);
                com.setItemMstCollection(items);
                em.merge(com);
            }            
        }
        c.setCompanyId(com);
        em.merge(c);
    }

    @Override
    public void removeItem(Integer id) {
        ItemMst c = this.getItemDetailsById(id);
        em.remove(c);
    }

    @Override
    public ItemMst getItemDetailsById(Integer id) {
        return em.find(ItemMst.class, id);
    }

    @Override
    public Collection<ItemMst> getAllItem() {
        return em.createNamedQuery("ItemMst.findAll", ItemMst.class).getResultList();
    }

    @Override
    public void addNewStock(String finYear, Integer itemId, Date asOnDate, Integer openingQty, Integer closingQty, Integer minQty, Integer maxQty, Double rate) {
        ItemMst item = this.getItemDetailsById(itemId);
        StockMst stk = new StockMst(itemId, finYear, asOnDate, openingQty, closingQty, minQty, maxQty, rate);
        em.persist(stk);
        
        Collection<StockMst> stocks = item.getStockMstCollection();
        if(!stocks.contains(stk)) {
            stocks.add(stk);
            item.setStockMstCollection(stocks);
            em.merge(item);
        }
    }

    @Override
    public void updateStock(Integer id, String finYear, Integer itemId, Date asOnDate, Integer openingQty, Integer closingQty, Integer minQty, Integer maxQty, Double rate) {
        ItemMst item = this.getItemDetailsById(itemId);
        StockMst stk = this.getStockDetailsById(id);
        stk.setItemId(item);
        stk.setFinYear(finYear);
        stk.setAsOnDate(asOnDate);
        stk.setOpeningQty(openingQty);
        stk.setClosingQty(closingQty);
        stk.setMinQty(minQty);
        stk.setMaxQty(maxQty);
        stk.setRate(rate);
        
        Collection<StockMst> stocks = item.getStockMstCollection();
        if(!stocks.contains(stk)) {
            stocks.add(stk);
            item.setStockMstCollection(stocks);
            em.merge(item);
        }
        em.merge(stk);
    }

    @Override
    public void removeStock(Integer id) {
        StockMst c = this.getStockDetailsById(id);
        em.remove(c);
    }

    @Override
    public StockMst getStockDetailsById(Integer id) {
        return em.find(StockMst.class, id);
    }

    @Override
    public Collection<StockMst> getAllStock() {        
        return em.createNamedQuery("StockMst.findAll", StockMst.class).getResultList();
    }

    @Override
    public void addNewTender(Date pubDate, String pubDesc, Date submittedDate, double emd, double docCost, Date deadlineDate, Date deadlineTime, Date openingDate, String pressNoteLoc, Boolean isApproved) {
        TenderMst tender = new TenderMst();
        tender.setPubDate(pubDate);
        tender.setPubDesc(pubDesc);
        tender.setSubmittedDate(submittedDate);
        tender.setEmd(emd);
        tender.setDocCost(docCost);
        tender.setDeadlineDate(deadlineDate);
        tender.setDeadlineTime(deadlineTime);
        tender.setOpeningDate(openingDate);
        tender.setPressNoteLoc(pressNoteLoc);
        tender.setIsApproved(isApproved);
        em.persist(tender);
    }

    @Override
    public void updateTender(Integer id, Date pubDate, String pubDesc, Date submittedDate, double emd, double docCost, Date deadlineDate, Date deadlineTime, Date openingDate, String pressNoteLoc, Boolean isApproved) {
        TenderMst tender = this.getTenderDetailsById(id);
        tender.setPubDate(pubDate);
        tender.setPubDesc(pubDesc);
        tender.setSubmittedDate(submittedDate);
        tender.setEmd(emd);
        tender.setDocCost(docCost);
        tender.setDeadlineDate(deadlineDate);
        tender.setDeadlineTime(deadlineTime);
        tender.setOpeningDate(openingDate);
        tender.setPressNoteLoc(pressNoteLoc);
        tender.setIsApproved(isApproved);
        em.merge(tender);
    }

    @Override
    public void removeTender(Integer id) {
        em.remove(this.getTenderBranchDetailsById(id));
    }

    @Override
    public TenderMst getTenderDetailsById(Integer id) {
        return em.find(TenderMst.class, id);
    }

    @Override
    public Collection<TenderMst> getAllTender() {
        return em.createNamedQuery("TenderMst.findAll", TenderMst.class).getResultList();
    }

    @Override
    public void addNewTenderDetails(Integer itemId, Integer tenderId, Integer qty, String remark) {
        Collection<TenderDetails> detailsCollection;
        TenderMst tender = this.getTenderDetailsById(tenderId);
        ItemMst item = em.find(ItemMst.class, itemId);
        TenderDetails details = new TenderDetails();
        details.setItemId(item);
        details.setQty(qty);
        details.setRemark(remark);
        details.setTenderId(tender);
        em.persist(details);
        
        detailsCollection = tender.getTenderDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            tender.setTenderDetailsCollection(detailsCollection);
            em.merge(tender);
        }
        
        detailsCollection = item.getTenderDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            item.setTenderDetailsCollection(detailsCollection);
            em.merge(item);
        }
    }

    @Override
    public void updateTenderDetails(Integer id, Integer tenderId, Integer itemId, Integer qty, String remark) {
        Collection<TenderDetails> detailsCollection;
        TenderMst tender = this.getTenderDetailsById(tenderId);
        ItemMst item = em.find(ItemMst.class, itemId);
        TenderDetails details = this.getTenderDetailsDetailsById(id);
        details.setItemId(item);
        details.setQty(qty);
        details.setRemark(remark);
        details.setTenderId(tender);
        
        detailsCollection = tender.getTenderDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            tender.setTenderDetailsCollection(detailsCollection);
            em.merge(tender);
        }
        
        detailsCollection = item.getTenderDetailsCollection();
        if(!detailsCollection.contains(details)) {
            detailsCollection.add(details);
            item.setTenderDetailsCollection(detailsCollection);
            em.merge(item);
        }
        em.merge(details);
    }

    @Override
    public void removeTenderDetails(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TenderDetails getTenderDetailsDetailsById(Integer id) {
        return em.find(TenderDetails.class, id);
    }

    @Override
    public Collection<TenderDetails> getAllTenderDetails() {
        return em.createNamedQuery("TenderDetails.findAll", TenderDetails.class).getResultList();
    }

    @Override
    public void addNewTenderBranch(Integer tenderId, Integer branchId) {
        Collection<TenderBranch> brCollection;
        TenderMst tender = this.getTenderDetailsById(tenderId);
        Branch branch = em.find(Branch.class, branchId);
        TenderBranch br = new TenderBranch();
        br.setBranchId(branch);
        br.setTenderId(tender);
        
        em.persist(br);
        
        brCollection = tender.getTenderBranchCollection();
        if(!brCollection.contains(br)) {
            brCollection.add(br);
            tender.setTenderBranchCollection(brCollection);
            em.merge(tender);
        }
        
        brCollection = branch.getTenderBranchCollection();
        if(!brCollection.contains(br)) {
            brCollection.add(br);
            branch.setTenderBranchCollection(brCollection);
            em.merge(branch);
        }
    }

    @Override
    public void updateTenderBranch(Integer id, Integer tenderId, Integer branchId) {
        Collection<TenderBranch> brCollection;
        TenderMst tender = this.getTenderDetailsById(tenderId);
        Branch branch = em.find(Branch.class, branchId);
        TenderBranch br = this.getTenderBranchDetailsById(id);
        br.setBranchId(branch);
        br.setTenderId(tender);
                
        brCollection = tender.getTenderBranchCollection();
        if(!brCollection.contains(br)) {
            brCollection.add(br);
            tender.setTenderBranchCollection(brCollection);
            em.merge(tender);
        }
        
        brCollection = branch.getTenderBranchCollection();
        if(!brCollection.contains(br)) {
            brCollection.add(br);
            branch.setTenderBranchCollection(brCollection);
            em.merge(branch);
        }
        em.merge(br);
    }

    @Override
    public void removeTenderBranch(Integer id) {
        em.remove(this.getTenderBranchDetailsById(id));
    }

    @Override
    public TenderBranch getTenderBranchDetailsById(Integer id) {
        return em.find(TenderBranch.class, id);
    }

    @Override
    public Collection<TenderBranch> getAllTenderBranch() {
        return em.createNamedQuery("TenderBranch.findAll", TenderBranch.class).getResultList();
    }
}
