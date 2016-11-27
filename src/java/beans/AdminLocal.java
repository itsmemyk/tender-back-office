/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.ejb.Local;
import entity.*;
import java.util.Collection;

/**
 *
 * @author Priyanka
 */
@Local
public interface AdminLocal {
 
    // Manage Department
    void addNewDepartment(String name);
    void updateDepartment(Integer id, String name);
    void removeDepartment(Integer id);
    Department getDepartmentDetailsById(Integer id);
    Collection<Department> getAllDepartment();
    
    // Manage Department
    void addNewDesignation(String name);
    void updateDesignation(Integer id, String name);
    void removeDesignation(Integer id);
    Designation getDesignationDetailsById(Integer id);
    Collection<Designation> getAllDesignation();
    
    // Manage Branch
    void addNewBranch(String name);
    void updateBranch(Integer id, String name, String address, String mobileNo);
    void removeBranch(Integer id);
    Branch getBranchDetailsById(Integer id);
    Collection<Branch> getAllBranch();
}
