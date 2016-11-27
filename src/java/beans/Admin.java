/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entity.*;
import java.util.*;
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
    
    private User manageUserDetails(User u, HashMap<String, Object> data) {        
        u.setName(data.get("name").toString());
        u.setAddress(data.get("address").toString());
        u.setGender(data.get("gender").toString());
        u.setMobileNo(data.get("mobileNo").toString());
        u.setEmailId(data.get("emailId").toString());
        u.setPassword(data.get("password").toString());
        u.setIsActive((boolean) data.get("isActive"));
        u.setIsOnline((boolean) data.get("isOnline"));
        
        if(data.containsKey("dob")) {
            u.setDob((Date) data.get("dob"));
        }
        if(data.containsKey("branchId")) {
            Branch b = this.getBranchDetailsById((Integer)data.get("branchId"));
            Collection<User> members = b.getUserCollection();
            if(!members.contains(u)) {
                members.add(u);
                b.setUserCollection(members);
                em.merge(b);
            }
            u.setBranchId(b);
        }
        if(data.containsKey("designationId")) {
            Designation d = this.getDesignationDetailsById((Integer)data.get("designationId"));
            Collection<User> members = d.getUserCollection();
            if(!members.contains(u)) {
                members.add(u);
                d.setUserCollection(members);
                em.merge(d);
            }
            u.setDesignationId(d);
        }
        
        if(data.containsKey("departmentId")) {
            Department d = this.getDepartmentDetailsById((Integer)data.get("departmentId"));
            Collection<User> members = d.getUserCollection();
            if(!members.contains(u)) {
                members.add(u);
                d.setUserCollection(members);
                em.merge(d);
            }
            u.setDepartmentId(d);
        }
        return u;
    }

    @Override
    public void addNewUser(HashMap<String, Object> data) {
        User u = new User();
        u = this.manageUserDetails(u, data);
        u.setDoj(new Date());
        em.persist(u);
    }

    @Override
    public void addNewUser(String name, String emailId, String password, String address, String gender, String mobileNo, Date dob, Integer branchId, Integer designationId, Integer departmentId, Boolean isActive, Boolean isOnline) {
        HashMap<String, Object> data = new HashMap();
        data.put("name", name);
        data.put("emailId", emailId);
        data.put("password", password);
        data.put("address", address);
        data.put("gender", gender);
        data.put("mobileNo", mobileNo);
        data.put("dob", dob);
        data.put("branchId", branchId);
        data.put("designationId", designationId);
        data.put("departmentId", departmentId);
        data.put("isActive", isActive);
        data.put("isOnline", isOnline);
        this.addNewUser(data);
    }

    @Override
    public void updateUser(Integer id, HashMap<String, Object> data) {
        User u = this.getUserDetailsById(id);
        u = this.manageUserDetails(u, data);
        em.merge(u);
    }

    @Override
    public void updateUser(Integer id, String name, String emailId, String password, String address, String gender, String mobileNo, Date dob, Integer branchId, Integer designationId, Integer departmentId, Boolean isActive, Boolean isOnline) {
        HashMap<String, Object> data = new HashMap();
        data.put("name", name);
        data.put("emailId", emailId);
        data.put("password", password);
        data.put("address", address);
        data.put("gender", gender);
        data.put("mobileNo", mobileNo);
        data.put("dob", dob);
        data.put("branchId", branchId);
        data.put("designationId", designationId);
        data.put("departmentId", departmentId);
        data.put("isActive", isActive);
        data.put("isOnline", isOnline);
        this.updateUser(id, data);
    }

    @Override
    public void removeUser(Integer id) {
        User u = this.getUserDetailsById(id);
        em.remove(u);
    }

    @Override
    public User getUserDetailsById(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    public Collection<User> getAllUser() {
        return em.createNamedQuery("User.findAll", User.class).getResultList();
    }

    @Override
    public void setUserStatus(Integer id, Boolean status) {
        User u = this.getUserDetailsById(id);
        u.setIsActive(status);
        em.merge(u);
    }

    @Override
    public void changeUserPassword(Integer id, String password) {
        User u = this.getUserDetailsById(id);
        u.setPassword(password);
        em.merge(u);
    }

    @Override
    public Boolean checkCredentials(String username, String password) {
        User u = em.createNamedQuery("User.findByEmailId", User.class).setParameter("emailId", username).getSingleResult();
        return u != null ? u.getPassword() == password : false;
    }
}
