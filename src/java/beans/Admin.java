/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entity.*;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Priyanka
 */
@Stateless
public class Admin implements AdminLocal {

    @PersistenceContext(unitName = "TenderModulePU")
    EntityManager em;
    
    @Override
    public void addNewDepartment(String name) {
        Department d = new Department();
        d.setTitle(name);
        em.persist(d);
    }

    @Override
    public void updateDepartment(Integer id, String name) {
        Department d = this.getDepartmentDetailsById(id);
        d.setTitle(name);
        em.merge(d);
    }

    @Override
    public void removeDepartment(Integer id) {
        Department d = this.getDepartmentDetailsById(id);
        em.remove(d);
    }

    @Override
    public Department getDepartmentDetailsById(Integer id) {
        return em.find(Department.class, id);
    }

    @Override
    public Collection<Department> getAllDepartment() {
        return em.createNamedQuery("Department.findAll", Department.class).getResultList();
    }
    
    @Override
    public void addNewDesignation(String name) {
        Designation d = new Designation();
        d.setTitle(name);
        em.persist(d);
    }

    @Override
    public void updateDesignation(Integer id, String name) {
        Designation d = this.getDesignationDetailsById(id);
        d.setTitle(name);
        em.merge(d);
    }

    @Override
    public void removeDesignation(Integer id) {
        Designation d = this.getDesignationDetailsById(id);
        em.remove(d);
    }

    @Override
    public Designation getDesignationDetailsById(Integer id) {
        return em.find(Designation.class, id);
    }

    @Override
    public Collection<Designation> getAllDesignation() {
        return em.createNamedQuery("Designation.findAll", Designation.class).getResultList();
    }
    
    @Override
    public void addNewBranch(String name) {
        Branch b = new Branch();
        b.setName(name);
        b.setAddress(name);
        b.setMobileNo(name);
        em.persist(b);
    }

    @Override
    public void updateBranch(Integer id, String name, String address, String mobileNo) {
        Branch b = this.getBranchDetailsById(id);
        b.setName(name);
        b.setAddress(name);
        b.setMobileNo(name);
        em.merge(b);
    }
    
    @Override
    public void removeBranch(Integer id) {
        Branch d = this.getBranchDetailsById(id);
        em.remove(d);
    }

    @Override
    public Branch getBranchDetailsById(Integer id) {
        return em.find(Branch.class, id);
    }

    @Override
    public Collection<Branch> getAllBranch() {
        return em.createNamedQuery("Branch.findAll", Branch.class).getResultList();
    }
}
