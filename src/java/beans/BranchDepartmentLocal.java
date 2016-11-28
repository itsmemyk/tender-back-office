/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import entity.*;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Priyanka
 */
@Local
public interface BranchDepartmentLocal {
    
    // manage Item Master
    void addNewDemand(String finYear, Integer deptId, Integer empId, Date demandDate);
    void updateDemand(Integer id, String finYear, Integer deptId, Integer empId, Date demandDate);
    void removeDemand(Integer id);
    DemandMst getDemandDetailsById(Integer id);
    Collection<DemandMst> getAllDemand();
    
    void addNewDemandDetails(Integer Qty , Integer itemId, Integer demandId, Integer supplierId);
    void updateDemandDetails(Integer id, Integer Qty , Integer itemId, Integer demandId, Integer supplierId);
    void removeDemandDetails(Integer id);
    DemandDetails getDemandDetailsDetailsById(Integer id);
    Collection<DemandDetails> getAllDemandDetails();
}
