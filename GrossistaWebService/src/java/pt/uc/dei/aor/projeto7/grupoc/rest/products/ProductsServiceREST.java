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
import javax.ws.rs.PathParam;
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
    public List<Product> findAllP(@Context HttpHeaders headers) throws Exception {

        return serviceEJB.findAllProducts(headers);

    }

    @GET
    @Path("{productId}")
    @Produces({"application/xml", "application/json"})
    public Product getProduct(@Context HttpHeaders headers, @PathParam("productId") String productId) {

        return serviceEJB.getProduct(headers, productId);

    }

    @GET
    @Path("{productId}/stock")
    @Produces("text/plain")
    public int getStockProduct(@Context HttpHeaders headers, @PathParam("productId") String productId) {

        return serviceEJB.getStockProduct(headers, productId);

    }

    @GET
    @Path("{productId}/available")
    @Produces("text/plain")
    public boolean availableProduct(@Context HttpHeaders headers, @PathParam("productId") String productId) {

        return serviceEJB.availableProduct(headers, productId);

    }

    @GET
    @Path("{productId}/dateofnextreposition")
    @Produces("text/plain")
    public String dateOfNextRepositionProduct(@Context HttpHeaders headers, @PathParam("productId") String productId) {

        return serviceEJB.dateOfNextRepositionProduct(headers, productId);

    }

    @GET
    @Path("model/{model}")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByModel(@Context HttpHeaders headers, @PathParam("model") String model) {

        return serviceEJB.findProductsByModel(headers, model);

    }

    @GET
    @Path("brand/{brand}")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByBrand(@Context HttpHeaders headers, @PathParam("brand") String brand) {

        return serviceEJB.findProductsByBrand(headers, brand);

    }

    @GET
    @Path("version/{version}")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByVersion(@Context HttpHeaders headers, @PathParam("version") String version) {

        return serviceEJB.findProductsByVersion(headers, version);

    }

    @GET
    @Path("designation")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByDesignation(@Context HttpHeaders headers) {

        return serviceEJB.findProductsByDesignation(headers);

    }

    @GET
    @Path("category/{category}")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByCategory(@Context HttpHeaders headers, @PathParam("category") String category) {

        return serviceEJB.findProductsByCategory(headers, category);

    }
}
