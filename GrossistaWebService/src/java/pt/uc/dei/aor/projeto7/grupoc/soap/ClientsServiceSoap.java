/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.soap;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pt.uc.dei.aor.projeto7.grupoc.entities.Client;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.NotRegistedEmailException;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.UserNotFoundException;
import pt.uc.dei.aor.projeto7.grupoc.facades.ClientFacade;

/**
 *
 * @author User
 */
@WebService(serviceName = "ClientsServiceSoap")
@Stateless()
public class ClientsServiceSoap {

    @EJB
    private ClientFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    public void create(@WebParam(name = "entity") Client entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbRef.findClientByApiKey(apikey);
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    public void edit(@WebParam(name = "entity") Client entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbRef.findClientByApiKey(apikey);
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    public void remove(@WebParam(name = "entity") Client entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbRef.findClientByApiKey(apikey);
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Client find(@WebParam(name = "id") Object id, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbRef.findClientByApiKey(apikey);
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Client> findAll(@WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbRef.findClientByApiKey(apikey);
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "getUserbyEmail")
    public Client getUserbyEmail(@WebParam(name = "email") String email, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException, NotRegistedEmailException {
        ejbRef.findClientByApiKey(apikey);
        return ejbRef.getUserbyEmail(email);
    }

    public Client findClientByApiKey(String apiKey) throws UserNotFoundException {
        return ejbRef.findClientByApiKey(apiKey);
    }

}
