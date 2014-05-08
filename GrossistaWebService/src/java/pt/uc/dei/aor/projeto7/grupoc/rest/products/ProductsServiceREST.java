/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.products;

import java.util.List;
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
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.UserNotFoundException;

/**
 *
 * @author User
 */
@Path("/products")
@Stateless
public class ProductsServiceREST {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private ServiceEJB serviceEJB;

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Product> findAll(@Context HttpHeaders headers) throws Exception {
        try {

            return serviceEJB.findAllProducts(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

    }

    @GET
    @Path("product")
    @Produces({"application/xml", "application/json"})
    public Product getProduct(@Context HttpHeaders headers) {
        try {

            return serviceEJB.getProduct(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("product/stock")
    @Produces("text/plain")
    public int getStockProduct(@Context HttpHeaders headers) {
        try {

            return serviceEJB.getStockProduct(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("product/available")
    @Produces("text/plain")
    public boolean availableProduct(@Context HttpHeaders headers) {
        try {
            return serviceEJB.availableProduct(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("product/dateofnextreposition")
    @Produces("text/plain")
    public String dateOfNextRepositionProduct(@Context HttpHeaders headers) {
        try {

            return serviceEJB.dateOfNextRepositionProduct(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("model")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByModel(@Context HttpHeaders headers) {
        try {

            return serviceEJB.findProductsByModel(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("brand")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByBrand(@Context HttpHeaders headers) {
        try {

            return serviceEJB.findProductsByBrand(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("version")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByVersion(@Context HttpHeaders headers) {
        try {

            return serviceEJB.findProductsByVersion(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("designation")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByDesignation(@Context HttpHeaders headers) {
        try {

            return serviceEJB.findProductsByDesignation(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    @GET
    @Path("category")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByCategory(@Context HttpHeaders headers) {
        try {

            return serviceEJB.findProductsByCategory(headers);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }
}
