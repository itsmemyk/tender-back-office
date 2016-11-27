/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entity.Department;
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
    
}
