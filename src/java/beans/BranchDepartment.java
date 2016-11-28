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
public class BranchDepartment implements BranchDepartmentLocal {

    @PersistenceContext(unitName = "TenderModulePU")
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void addNewDemand(String finYear, Integer deptId, Integer empId, Date demandDate) {
        Collection<DemandMst> allDMD;
        Department dept = em.find(Department.class, deptId);
        User emp = em.find(User.class, empId);
        DemandMst dmd = new DemandMst();
        dmd.setFinYear(finYear);
        dmd.setDeptId(dept);
        dmd.setEmpId(emp);
        dmd.setDemandDate(demandDate);        
        em.persist(dmd);
        
        allDMD = dept.getDemandMstCollection();
        if(!allDMD.contains(dmd)) {
            allDMD.add(dmd);
            dept.setDemandMstCollection(allDMD);
            em.merge(dept);
        }
        
        allDMD = emp.getDemandMstCollection();
        if(!allDMD.contains(dmd)) {
            allDMD.add(dmd);
            emp.setDemandMstCollection(allDMD);
            em.merge(emp);
        }
    }

    @Override
    public void updateDemand(Integer id, String finYear, Integer deptId, Integer empId, Date demandDate) {
        Collection<DemandMst> allDMD;
        Department dept = em.find(Department.class, deptId);
        User emp = em.find(User.class, empId);
        DemandMst dmd = this.getDemandDetailsById(id);
        dmd.setFinYear(finYear);
        dmd.setDeptId(dept);
        dmd.setEmpId(emp);
        dmd.setDemandDate(demandDate);        
        
        allDMD = dept.getDemandMstCollection();
        if(!allDMD.contains(dmd)) {
            allDMD.add(dmd);
            dept.setDemandMstCollection(allDMD);
            em.merge(dept);
        }
        allDMD = emp.getDemandMstCollection();
        if(!allDMD.contains(dmd)) {
            allDMD.add(dmd);
            emp.setDemandMstCollection(allDMD);
            em.merge(emp);
        }
        em.merge(dmd);
    }

    @Override
    public void removeDemand(Integer id) {
        DemandMst dmd = this.getDemandDetailsById(id);
        em.remove(dmd);
    }

    @Override
    public DemandMst getDemandDetailsById(Integer id) {
        return em.find(DemandMst.class, id);
    }

    @Override
    public Collection<DemandMst> getAllDemand() {
        return em.createNamedQuery("DemandMst.findAll", DemandMst.class).getResultList();
    }

    @Override
    public void addNewDemandDetails(Integer Qty, Integer itemId, Integer demandId, Integer supplierId) {
        Collection<DemandDetails> detailsCollection;
        DemandMst demand = em.find(DemandMst.class, demandId);
        ItemMst item = em.find(ItemMst.class, itemId);
        Supplier sup = em.find(Supplier.class, supplierId);
        
        DemandDetails details = new DemandDetails();
        details.setDemandId(demand);
        details.setItemId(item);
        details.setSupplierId(sup);
        details.setQty(Qty);
        em.persist(details);
        
        detailsCollection = demand.getDemandDetailsCollection();
        if(!detailsCollection.contains(demand)) {
            detailsCollection.add(details);
            demand.setDemandDetailsCollection(detailsCollection);
            em.merge(demand);
        }
        
        detailsCollection = item.getDemandDetailsCollection();
        if(!detailsCollection.contains(demand)) {
            detailsCollection.add(details);
            item.setDemandDetailsCollection(detailsCollection);
            em.merge(item);
        }
        
        detailsCollection = sup.getDemandDetailsCollection();
        if(!detailsCollection.contains(demand)) {
            detailsCollection.add(details);
            sup.setDemandDetailsCollection(detailsCollection);
            em.merge(sup);
        }
    }

    @Override
    public void updateDemandDetails(Integer id, Integer Qty, Integer itemId, Integer demandId, Integer supplierId) {
        Collection<DemandDetails> detailsCollection;
        DemandMst demand = em.find(DemandMst.class, demandId);
        ItemMst item = em.find(ItemMst.class, itemId);
        Supplier sup = em.find(Supplier.class, supplierId);
        
        DemandDetails details = this.getDemandDetailsDetailsById(id);
        details.setDemandId(demand);
        details.setItemId(item);
        details.setSupplierId(sup);
        details.setQty(Qty);
        
        detailsCollection = demand.getDemandDetailsCollection();
        if(!detailsCollection.contains(demand)) {
            detailsCollection.add(details);
            demand.setDemandDetailsCollection(detailsCollection);
            em.merge(demand);
        }
        
        detailsCollection = item.getDemandDetailsCollection();
        if(!detailsCollection.contains(demand)) {
            detailsCollection.add(details);
            item.setDemandDetailsCollection(detailsCollection);
            em.merge(item);
        }
        
        detailsCollection = sup.getDemandDetailsCollection();
        if(!detailsCollection.contains(demand)) {
            detailsCollection.add(details);
            sup.setDemandDetailsCollection(detailsCollection);
            em.merge(sup);
        }
        
        em.merge(details);
    }

    @Override
    public void removeDemandDetails(Integer id) {
        DemandDetails dd = this.getDemandDetailsDetailsById(id);
        em.remove(dd);
    }

    @Override
    public DemandDetails getDemandDetailsDetailsById(Integer id) {
        return em.find(DemandDetails.class, id);        
    }

    @Override
    public Collection<DemandDetails> getAllDemandDetails() {
        return em.createNamedQuery("DemandDetails.findAll", DemandDetails.class).getResultList();
    }
}
