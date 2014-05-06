/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.clients;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import pt.uc.dei.aor.projeto7.grupoc.entities.Client;
import pt.uc.dei.aor.projeto7.grupoc.facades.ClientFacade;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.NotRegistedEmailException;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.PasswordException;

/**
 *
 * @author User
 */
@Stateless
@Path("/clients")
public class ClientsServiceREST {

    @Inject
    private ClientFacade clientFacade;

    public ClientsServiceREST() {

    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Client entity) {

        clientFacade.create(entity);
    }

    @POST
    @Path("login/{email}/{password}")
    @Produces({"application/xml", "application/json"})
    public String login(@PathParam("email") String email, @PathParam("password") String password) {
        try {
            clientFacade.searchLogged(email, password);
            return "Successfully logged";
        } catch (NotRegistedEmailException | PasswordException ex) {
            Logger.getLogger(ClientsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }

    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Client entity) {
        clientFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        clientFacade.remove(find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Client find(@PathParam("id") Integer id) {
        return clientFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Client> findAll() {
        return clientFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Client> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return clientFacade.findRange(new int[]{from, to});
    }

}