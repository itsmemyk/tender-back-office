/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ws;

import beans.SupplierClientLocal;
import entity.Supplier;
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
@WebService(serviceName = "SupplierClientWS")
@Stateless()
public class SupplierClientWS {
    @EJB
    private SupplierClientLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "newSupplierRegistration")
    @Oneway
    public void newSupplierRegistration(@WebParam(name = "companyName") String companyName, @WebParam(name = "personName") String personName, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "state") String state, @WebParam(name = "zipCode") String zipCode, @WebParam(name = "contactNo") String contactNo, @WebParam(name = "mobileNo") String mobileNo, @WebParam(name = "faxNo") String faxNo, @WebParam(name = "emailId") String emailId, @WebParam(name = "password") String password, @WebParam(name = "website") String website, @WebParam(name = "gstNo") String gstNo, @WebParam(name = "gstDate") Date gstDate, @WebParam(name = "cstNo") String cstNo, @WebParam(name = "cstDate") Date cstDate, @WebParam(name = "tinNo") String tinNo, @WebParam(name = "tinDate") Date tinDate, @WebParam(name = "companyDesc") String companyDesc, @WebParam(name = "isActive") Boolean isActive, @WebParam(name = "isOnline") Boolean isOnline) {
        ejbRef.newSupplierRegistration(companyName, personName, address, city, state, zipCode, contactNo, mobileNo, faxNo, emailId, password, website, gstNo, gstDate, cstNo, cstDate, tinNo, tinDate, companyDesc, isActive, isOnline);
    }

    @WebMethod(operationName = "updateSupplier")
    @Oneway
    public void updateSupplier(@WebParam(name = "id") Integer id, @WebParam(name = "companyName") String companyName, @WebParam(name = "personName") String personName, @WebParam(name = "address") String address, @WebParam(name = "city") String city, @WebParam(name = "state") String state, @WebParam(name = "zipCode") String zipCode, @WebParam(name = "contactNo") String contactNo, @WebParam(name = "mobileNo") String mobileNo, @WebParam(name = "faxNo") String faxNo, @WebParam(name = "emailId") String emailId, @WebParam(name = "password") String password, @WebParam(name = "website") String website, @WebParam(name = "gstNo") String gstNo, @WebParam(name = "gstDate") Date gstDate, @WebParam(name = "cstNo") String cstNo, @WebParam(name = "cstDate") Date cstDate, @WebParam(name = "tinNo") String tinNo, @WebParam(name = "tinDate") Date tinDate, @WebParam(name = "companyDesc") String companyDesc, @WebParam(name = "isActive") Boolean isActive, @WebParam(name = "isOnline") Boolean isOnline) {
        ejbRef.updateSupplier(id, companyName, personName, address, city, state, zipCode, contactNo, mobileNo, faxNo, emailId, password, website, gstNo, gstDate, cstNo, cstDate, tinNo, tinDate, companyDesc, isActive, isOnline);
    }

    @WebMethod(operationName = "removeSupploer")
    @Oneway
    public void removeSupploer(@WebParam(name = "id") Integer id) {
        ejbRef.removeSupploer(id);
    }

    @WebMethod(operationName = "getSupplierDetailsById")
    public Supplier getSupplierDetailsById(@WebParam(name = "id") Integer id) {
        return ejbRef.getSupplierDetailsById(id);
    }

    @WebMethod(operationName = "getAllSupplier")
    public Collection<Supplier> getAllSupplier() {
        return ejbRef.getAllSupplier();
    }
    
}
