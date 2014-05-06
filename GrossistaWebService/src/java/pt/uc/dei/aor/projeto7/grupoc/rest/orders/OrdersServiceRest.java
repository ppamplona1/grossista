/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.orders;

import java.util.List;
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
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.facades.Order1Facade;

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
    private Order1Facade orderfacade;

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Order1 entity) {
        orderfacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Order1 entity) {
        orderfacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        orderfacade.remove(find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Order1 find(@PathParam("id") Integer id) {
        return orderfacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Order1> findAll() {
        return orderfacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Order1> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return orderfacade.findRange(new int[]{from, to});
    }
}
