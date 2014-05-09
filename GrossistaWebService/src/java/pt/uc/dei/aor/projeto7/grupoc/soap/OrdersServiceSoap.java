/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.soap;

import java.util.List;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.UserNotFoundException;
import pt.uc.dei.aor.projeto7.grupoc.facades.ClientFacade;
import pt.uc.dei.aor.projeto7.grupoc.facades.Order1Facade;

/**
 *
 * @author User
 */
@WebService(serviceName = "OrdersServiceSoap")
public class OrdersServiceSoap {

    @Inject
    private Order1Facade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @Inject
    private ClientFacade ejbClient;

    @WebMethod(operationName = "create")
    public void create(@WebParam(name = "entity") Order1 entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    public void edit(@WebParam(name = "entity") Order1 entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    public void remove(@WebParam(name = "entity") Order1 entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Order1 find(@WebParam(name = "id") Object id, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Order1> findAll(@WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "allOrdersByClient")
    public List<Order1> allOrdersByClient(@WebParam(name = "IdClient") Integer IdClient, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.allOrdersByClient(IdClient);
    }

}
