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
public interface SupplierClientLocal {
    // Manage Supplier
    void newSupplierRegistration(String companyName, String personName, String address, String city, String state, String zipCode, String contactNo, String mobileNo, String faxNo, String emailId, String password, String website, String gstNo, Date gstDate, String cstNo, Date cstDate, String tinNo, Date tinDate, String companyDesc, Boolean isActive, Boolean isOnline);
    void updateSupplier(Integer id, String companyName, String personName, String address, String city, String state, String zipCode, String contactNo, String mobileNo, String faxNo, String emailId, String password, String website, String gstNo, Date gstDate, String cstNo, Date cstDate, String tinNo, Date tinDate, String companyDesc, Boolean isActive, Boolean isOnline);
    void removeSupploer(Integer id);
    Supplier getSupplierDetailsById(Integer id);
    Collection<Supplier> getAllSupplier();
}
