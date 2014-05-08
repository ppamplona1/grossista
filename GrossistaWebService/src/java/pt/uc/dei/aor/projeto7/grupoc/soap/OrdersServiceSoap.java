/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.soap;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.facades.Order1Facade;

/**
 *
 * @author User
 */
@WebService(serviceName = "OrdersServiceSoap")
public class OrdersServiceSoap {
    @EJB
    private Order1Facade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Order1 entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Order1 entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Order1 entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Order1 find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Order1> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Order1> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "allOrdersByClient")
    public List<Order1> allOrdersByClient(@WebParam(name = "IdClient") Integer IdClient) {
        return ejbRef.allOrdersByClient(IdClient);
    }

}
