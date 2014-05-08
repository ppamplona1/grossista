/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.clients;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import pt.uc.dei.aor.projeto7.grupoc.ejb.ServiceEJB;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.UserNotFoundException;

/**
 *
 * @author User
 */
@Stateless
@Path("/clients")
public class ClientsServiceREST {

    @Inject
    private ServiceEJB serviceEJB;

    public ClientsServiceREST() {

    }

    @GET
    @Path("{clientId}/orders")
    @Produces({"application/xml", "application/json"})
    public Collection<Order1> ordersListClient(@Context HttpHeaders headers) {
        try {

            return serviceEJB.ordersListClient(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ClientsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
