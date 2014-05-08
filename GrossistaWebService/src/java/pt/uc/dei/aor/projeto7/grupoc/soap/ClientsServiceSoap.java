/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.soap;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pt.uc.dei.aor.projeto7.grupoc.entities.Client;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.NotRegistedEmailException;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.PasswordException;
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
    @Oneway
    public void create(@WebParam(name = "entity") Client entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Client entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Client entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Client find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Client> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Client> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "getUserbyEmail")
    public Client getUserbyEmail(@WebParam(name = "email") String email) throws NotRegistedEmailException {
        return ejbRef.getUserbyEmail(email);
    }

    @WebMethod(operationName = "searchLogged")
    public Client searchLogged(@WebParam(name = "email") String email, @WebParam(name = "password") String password) throws NotRegistedEmailException, PasswordException {
        return ejbRef.searchLogged(email, password);
    }

    @WebMethod(operationName = "findClientByApiKey")
    public Client findClientByApiKey(@WebParam(name = "apiKey") String apiKey) throws UserNotFoundException {
        return ejbRef.findClientByApiKey(apiKey);
    }

}
