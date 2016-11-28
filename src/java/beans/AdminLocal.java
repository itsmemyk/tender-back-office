/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import javax.ejb.Local;
import entity.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

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
    
    // Manage User
    void addNewUser(HashMap<String, Object> data);
    void addNewUser(String name, String emailId, String password, String address, String gender, String mobileNo, Date dob, Integer branchId, Integer designationId, Integer departmentId, Boolean isActive, Boolean isOnline);
    void updateUser(Integer id, HashMap<String, Object> data);
    void updateUser(Integer id, String name, String emailId, String password, String address, String gender, String mobileNo, Date dob, Integer branchId, Integer designationId, Integer departmentId, Boolean isActive, Boolean isOnline);
    void removeUser(Integer id);
    void setUserStatus(Integer id, Boolean status);    
    void changeUserPassword(Integer id, String password);
    Boolean checkCredentials(String username, String password);
    User getUserDetailsById(Integer id);
    Collection<User> getAllUser();

    // Manage Circular Notice
    void addNewCircularNotice(Date cirDate, String noticeDesc, Integer empId, Integer viewDesignationId, Integer viewDepartmentId, Date fromDate, Date toDate);
    void updateCircularNotice(Integer id, Date cirDate, String noticeDesc, Integer empId, Integer viewDesignationId, Integer viewDepartmentId, Date fromDate, Date toDate);
    void removeCircularNotice(Integer id);
    CircularNotice getCircularNoticeDetailsById(Integer id);
    Collection<CircularNotice> getAllCircularNotice();
    
    void addNewCircularNoticeDetails(Integer noticeId, Integer empId, Boolean isRead, Date readDate);
    void updateCircularNoticeDetails(Integer id, Integer noticeId, Integer empId, Boolean isRead, Date readDate);
    void removeCircularNoticeDetails(Integer id);
    CircularNoticeDetails getCircularNoticeDetailsDetailsById(Integer id);
    Collection<CircularNoticeDetails> getAllCircularNoticeDetails();    
}
