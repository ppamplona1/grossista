/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.products;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import pt.uc.dei.aor.projeto7.grupoc.ejb.ServiceEJB;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;

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

        return serviceEJB.findAllProducts(headers);

    }

    @GET
    @Path("product")
    @Produces({"application/xml", "application/json"})
    public Product getProduct(@Context HttpHeaders headers) {

        return serviceEJB.getProduct(headers);

    }

    @GET
    @Path("product/stock")
    @Produces("text/plain")
    public int getStockProduct(@Context HttpHeaders headers) {

        return serviceEJB.getStockProduct(headers);

    }

    @GET
    @Path("product/available")
    @Produces("text/plain")
    public boolean availableProduct(@Context HttpHeaders headers) {

        return serviceEJB.availableProduct(headers);

    }

    @GET
    @Path("product/dateofnextreposition")
    @Produces("text/plain")
    public String dateOfNextRepositionProduct(@Context HttpHeaders headers) {

        return serviceEJB.dateOfNextRepositionProduct(headers);

    }

    @GET
    @Path("model")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByModel(@Context HttpHeaders headers) {

        return serviceEJB.findProductsByModel(headers);

    }

    @GET
    @Path("brand")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByBrand(@Context HttpHeaders headers) {

        return serviceEJB.findProductsByBrand(headers);

    }

    @GET
    @Path("version")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByVersion(@Context HttpHeaders headers) {

        return serviceEJB.findProductsByVersion(headers);

    }

    @GET
    @Path("designation")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByDesignation(@Context HttpHeaders headers) {

        return serviceEJB.findProductsByDesignation(headers);

    }

    @GET
    @Path("category")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByCategory(@Context HttpHeaders headers) {

        return serviceEJB.findProductsByCategory(headers);

    }
}
