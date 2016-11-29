/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import beans.BranchDepartmentLocal;
import entity.DemandDetails;
import entity.DemandMst;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Mayank
 */
@WebService(serviceName = "BranchDepartmentWS")
@Stateless()
public class BranchDepartmentWS {
    @EJB
    private BranchDepartmentLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "addNewDemand")
    @Oneway
    public void addNewDemand(@WebParam(name = "finYear") String finYear, @WebParam(name = "deptId") Integer deptId, @WebParam(name = "empId") Integer empId, @WebParam(name = "demandDate") Date demandDate) {
        ejbRef.addNewDemand(finYear, deptId, empId, demandDate);
    }

    @WebMethod(operationName = "updateDemand")
    @Oneway
    public void updateDemand(@WebParam(name = "id") Integer id, @WebParam(name = "finYear") String finYear, @WebParam(name = "deptId") Integer deptId, @WebParam(name = "empId") Integer empId, @WebParam(name = "demandDate") Date demandDate) {
        ejbRef.updateDemand(id, finYear, deptId, empId, demandDate);
    }

    @WebMethod(operationName = "removeDemand")
    @Oneway
    public void removeDemand(@WebParam(name = "id") Integer id) {
        ejbRef.removeDemand(id);
    }

    @WebMethod(operationName = "getDemandDetailsById")
    public DemandMst getDemandDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getDemandDetailsById(id);
    }

    @WebMethod(operationName = "getAllDemand")
    public Collection<DemandMst> getAllDemand() {
        return ejbRef.getAllDemand();
    }

    @WebMethod(operationName = "addNewDemandDetails")
    @Oneway
    public void addNewDemandDetails(@WebParam(name = "Qty") Integer Qty, @WebParam(name = "itemId") Integer itemId, @WebParam(name = "demandId") Integer demandId, @WebParam(name = "supplierId") Integer supplierId) {
        ejbRef.addNewDemandDetails(Qty, itemId, demandId, supplierId);
    }

    @WebMethod(operationName = "updateDemandDetails")
    @Oneway
    public void updateDemandDetails(@WebParam(name = "id") Integer id, @WebParam(name = "Qty") Integer Qty, @WebParam(name = "itemId") Integer itemId, @WebParam(name = "demandId") Integer demandId, @WebParam(name = "supplierId") Integer supplierId) {
        ejbRef.updateDemandDetails(id, Qty, itemId, demandId, supplierId);
    }

    @WebMethod(operationName = "removeDemandDetails")
    @Oneway
    public void removeDemandDetails(@WebParam(name = "id") Integer id) {
        ejbRef.removeDemandDetails(id);
    }

    @WebMethod(operationName = "getDemandDetailsDetailsById")
    public DemandDetails getDemandDetailsDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getDemandDetailsDetailsById(id);
    }

    @WebMethod(operationName = "getAllDemandDetails")
    public Collection<DemandDetails> getAllDemandDetails() {
        return ejbRef.getAllDemandDetails();
    }
    
}
