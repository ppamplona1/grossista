/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.orders;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import pt.uc.dei.aor.projeto7.grupoc.ejb.ServiceEJB;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;

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
    public boolean create(@Context HttpHeaders headers) {

        return serviceEJB.createOrder(headers);

    }

    @PUT
    @Path("edit")
    @Produces("text/plain")
    public boolean edit(@Context HttpHeaders headers) {

        return serviceEJB.editOrder(headers);

    }

    @DELETE
    @Path("{orderId}/remove")
    @Produces("text/plain")
    public boolean remove(@Context HttpHeaders headers, @PathParam("orderId") String orderId) {

        return serviceEJB.removeOrder(headers, orderId);

    }

    @GET
    @Path("{orderId}/find")
    @Produces({"application/xml", "application/json"})
    public Order1 find(@Context HttpHeaders headers, @PathParam("orderId") String orderId) {

        return serviceEJB.findOrder(headers, orderId);

    }

    @GET
    @Path("{orderId}/expecteddate")
    @Produces({"application/xml", "application/json"})
    public Date getExpectedDateFromEdition(@Context HttpHeaders headers, @PathParam("orderId") String orderId) {

        return serviceEJB.getExpectedDateFromEdition(headers, orderId);

    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Order1> findAll(@Context HttpHeaders headers) {

        return serviceEJB.findAllOrders(headers);

    }

}
