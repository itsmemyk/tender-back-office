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
}
