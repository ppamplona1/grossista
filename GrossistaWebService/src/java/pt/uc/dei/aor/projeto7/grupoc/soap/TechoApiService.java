/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.soap;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.core.HttpHeaders;
import pt.uc.dei.aor.projeto7.grupoc.ejb.ServiceEJB;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;

/**
 *
 * @author User
 */
@WebService(serviceName = "TechoApiService")
@Stateless()
public class TechoApiService {
    @EJB
    private ServiceEJB ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "ordersListClient")
    public Collection<Order1> ordersListClient(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.ordersListClient(headers);
    }

    @WebMethod(operationName = "create")
    public boolean create(@WebParam(name = "headers") HttpHeaders headers) throws Exception {
        return ejbRef.create(headers);
    }

    @WebMethod(operationName = "edit")
    public boolean edit(@WebParam(name = "headers") HttpHeaders headers) throws Exception {
        return ejbRef.editOrder(headers);
    }

    @WebMethod(operationName = "remove")
    public boolean remove(@WebParam(name = "headers") HttpHeaders headers) throws Exception {
        return ejbRef.removeOrder(headers);
    }

    @WebMethod(operationName = "find")
    public Order1 find(@WebParam(name = "headers") HttpHeaders headers) throws Exception {
        return ejbRef.findOrder(headers);
    }

    @WebMethod(operationName = "getExpectedDateFromEdition")
    public Date getExpectedDateFromEdition(@WebParam(name = "headers") HttpHeaders headers) throws Exception {
        return ejbRef.getExpectedDateFromEdition(headers);
    }

    @WebMethod(operationName = "findAllOrders")
    public List<Order1> findAllOrders(@WebParam(name = "headers") HttpHeaders headers) throws Exception {
        return ejbRef.findAllOrders(headers);
    }

    @WebMethod(operationName = "findAllProducts")
    public List<Product> findAllProducts(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.findAllProducts(headers);
    }

    @WebMethod(operationName = "getProduct")
    public Product getProduct(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.getProduct(headers);
    }

    @WebMethod(operationName = "getStockProduct")
    public int getStockProduct(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.getStockProduct(headers);
    }

    @WebMethod(operationName = "availableProduct")
    public boolean availableProduct(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.availableProduct(headers);
    }

    @WebMethod(operationName = "dateOfNextRepositionProduct")
    public String dateOfNextRepositionProduct(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.dateOfNextRepositionProduct(headers);
    }

    @WebMethod(operationName = "findProductsByModel")
    public List<Product> findProductsByModel(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.findProductsByModel(headers);
    }

    @WebMethod(operationName = "findProductsByBrand")
    public List<Product> findProductsByBrand(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.findProductsByBrand(headers);
    }

    @WebMethod(operationName = "findProductsByVersion")
    public List<Product> findProductsByVersion(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.findProductsByVersion(headers);
    }

    @WebMethod(operationName = "findProductsByDesignation")
    public List<Product> findProductsByDesignation(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.findProductsByDesignation(headers);
    }

    @WebMethod(operationName = "findProductsByCategory")
    public List<Product> findProductsByCategory(@WebParam(name = "headers") HttpHeaders headers) {
        return ejbRef.findProductsByCategory(headers);
    }

}
