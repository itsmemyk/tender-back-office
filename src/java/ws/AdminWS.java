/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import beans.AdminLocal;
import entity.Branch;
import entity.Department;
import entity.Designation;
import entity.User;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;

/**
 *
 * @author Mayank
 */
@WebService(serviceName = "AdminWS")
@Stateless()
public class AdminWS {
    @EJB
    private AdminLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addNewDepartment")
    @Oneway
    public void addNewDepartment(@WebParam(name = "name") String name) {
        ejbRef.addNewDepartment(name);
    }

    @WebMethod(operationName = "updateDepartment")
    @Oneway
    public void updateDepartment(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name) {
        ejbRef.updateDepartment(id, name);
    }

    @WebMethod(operationName = "removeDepartment")
    @Oneway
    public void removeDepartment(@WebParam(name = "id") Integer id) {
        ejbRef.removeDepartment(id);
    }

    @WebMethod(operationName = "getDepartmentDetailsById")
    public Department getDepartmentDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getDepartmentDetailsById(id);
    }

    @WebMethod(operationName = "getAllDepartment")
    public Collection<Department> getAllDepartment() {
        return ejbRef.getAllDepartment();
    }

    @WebMethod(operationName = "addNewDesignation")
    @Oneway
    public void addNewDesignation(@WebParam(name = "name") String name) {
        ejbRef.addNewDesignation(name);
    }

    @WebMethod(operationName = "updateDesignation")
    @Oneway
    public void updateDesignation(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name) {
        ejbRef.updateDesignation(id, name);
    }

    @WebMethod(operationName = "removeDesignation")
    @Oneway
    public void removeDesignation(@WebParam(name = "id") Integer id) {
        ejbRef.removeDesignation(id);
    }

    @WebMethod(operationName = "getDesignationDetailsById")
    public Designation getDesignationDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getDesignationDetailsById(id);
    }

    @WebMethod(operationName = "getAllDesignation")
    public Collection<Designation> getAllDesignation() {
        return ejbRef.getAllDesignation();
    }

    @WebMethod(operationName = "addNewBranch")
    @Oneway
    public void addNewBranch(@WebParam(name = "name") String name) {
        ejbRef.addNewBranch(name);
    }

    @WebMethod(operationName = "updateBranch")
    @Oneway
    public void updateBranch(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name, @WebParam(name = "address") String address, @WebParam(name = "mobileNo") String mobileNo) {
        ejbRef.updateBranch(id, name, address, mobileNo);
    }

    @WebMethod(operationName = "removeBranch")
    @Oneway
    public void removeBranch(@WebParam(name = "id") Integer id) {
        ejbRef.removeBranch(id);
    }

    @WebMethod(operationName = "getBranchDetailsById")
    public Branch getBranchDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getBranchDetailsById(id);
    }

    @WebMethod(operationName = "getAllBranch")
    public Collection<Branch> getAllBranch() {
        return ejbRef.getAllBranch();
    }

    @WebMethod(operationName = "addNewUser")
    @Oneway
    public void addNewUser(@WebParam(name = "data") HashMap<String, Object> data) {
        ejbRef.addNewUser(data);
    }

    @WebMethod(operationName = "addNewUser_1")
    @RequestWrapper(className = "addNewUser_1")
    @Oneway
    public void addNewUser(@WebParam(name = "name") String name, @WebParam(name = "emailId") String emailId, @WebParam(name = "password") String password, @WebParam(name = "address") String address, @WebParam(name = "gender") String gender, @WebParam(name = "mobileNo") String mobileNo, @WebParam(name = "dob") Date dob, @WebParam(name = "branchId") Integer branchId, @WebParam(name = "designationId") Integer designationId, @WebParam(name = "departmentId") Integer departmentId, @WebParam(name = "isActive") Boolean isActive, @WebParam(name = "isOnline") Boolean isOnline) {
        ejbRef.addNewUser(name, emailId, password, address, gender, mobileNo, dob, branchId, designationId, departmentId, isActive, isOnline);
    }

    @WebMethod(operationName = "updateUser")
    @Oneway
    public void updateUser(@WebParam(name = "id") Integer id, @WebParam(name = "data") HashMap<String, Object> data) {
        ejbRef.updateUser(id, data);
    }

    @WebMethod(operationName = "updateUser_1")
    @RequestWrapper(className = "updateUser_1")
    @Oneway
    public void updateUser(@WebParam(name = "id") Integer id, @WebParam(name = "name") String name, @WebParam(name = "emailId") String emailId, @WebParam(name = "password") String password, @WebParam(name = "address") String address, @WebParam(name = "gender") String gender, @WebParam(name = "mobileNo") String mobileNo, @WebParam(name = "dob") Date dob, @WebParam(name = "branchId") Integer branchId, @WebParam(name = "designationId") Integer designationId, @WebParam(name = "departmentId") Integer departmentId, @WebParam(name = "isActive") Boolean isActive, @WebParam(name = "isOnline") Boolean isOnline) {
        ejbRef.updateUser(id, name, emailId, password, address, gender, mobileNo, dob, branchId, designationId, departmentId, isActive, isOnline);
    }

    @WebMethod(operationName = "removeUser")
    @Oneway
    public void removeUser(@WebParam(name = "id") Integer id) {
        ejbRef.removeUser(id);
    }

    @WebMethod(operationName = "setUserStatus")
    @Oneway
    public void setUserStatus(@WebParam(name = "id") Integer id, @WebParam(name = "status") Boolean status) {
        ejbRef.setUserStatus(id, status);
    }

    @WebMethod(operationName = "changeUserPassword")
    @Oneway
    public void changeUserPassword(@WebParam(name = "id") Integer id, @WebParam(name = "password") String password) {
        ejbRef.changeUserPassword(id, password);
    }

    @WebMethod(operationName = "checkCredentials")
    public Boolean checkCredentials(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return ejbRef.checkCredentials(username, password);
    }

    @WebMethod(operationName = "getUserDetailsById")
    public User getUserDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getUserDetailsById(id);
    }

    @WebMethod(operationName = "getAllUser")
    public Collection<User> getAllUser() {
        return ejbRef.getAllUser();
    }
    
}
