/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.orders;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/orders")
public class OrdersServiceRest {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private ServiceEJB serviceEJB;

    @POST
    @Produces("text/plain")
    public boolean create(@Context HttpHeaders headers) throws Exception {
        try {

            return serviceEJB.create(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @PUT
    @Path("edit")
    @Produces("text/plain")
    public boolean edit(@Context HttpHeaders headers) throws Exception {
        try {

            return serviceEJB.edit(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @DELETE
    @Path("remove")
    @Produces("text/plain")
    public boolean remove(@Context HttpHeaders headers) throws Exception {
        try {

            return serviceEJB.remove(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("find")
    @Produces({"application/xml", "application/json"})
    public Order1 find(@Context HttpHeaders headers) throws Exception {
        try {

            return serviceEJB.find(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("{id}/expecteddate")
    @Produces({"application/xml", "application/json"})
    public Date getExpectedDateFromEdition(@Context HttpHeaders headers) throws Exception {
        try {

            return serviceEJB.getExpectedDateFromEdition(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Order1> findAll(@Context HttpHeaders headers) throws Exception {
        try {

            return serviceEJB.findAllOrders(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
