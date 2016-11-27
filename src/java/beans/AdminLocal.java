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
}
