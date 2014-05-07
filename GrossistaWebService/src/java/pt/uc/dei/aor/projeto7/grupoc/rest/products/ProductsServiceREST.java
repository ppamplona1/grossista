/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.products;

import java.text.SimpleDateFormat;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;
import pt.uc.dei.aor.projeto7.grupoc.facades.ProductFacade;

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
    private ProductFacade productFacade;

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(Product entity) {
        productFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") String id, Product entity) {
        productFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        productFacade.remove(getProduct(id));
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Product> findAll() {
        return productFacade.findAll();

    }

    @GET
    @Path("{productId}")
    @Produces({"application/xml", "application/json"})
    public Product getProduct(@PathParam("productId") String productId) {

        return productFacade.getProduct(Integer.parseInt(productId));
    }

    @GET
    @Path("{productId}/stock")
    @Produces("text/plain")
    public int getStockProduct(@PathParam("productId") String productId) {

        return productFacade.stockQtyByProduct(productFacade.
                find(Integer.parseInt(productId)));
    }

    @GET
    @Path("{productId}/available")
    @Produces("text/plain")
    public boolean availableProduct(@PathParam("productId") String productId) {

        return productFacade.stockOKProduct(Integer.parseInt(productId));
    }

    @GET
    @Path("{productId}/dateofnextreposition")
    @Produces("text/plain")
    public String dateOfNextRepositionProduct(@PathParam("productId") String productId) {

        return new SimpleDateFormat("dd-MM-yyyy").format(productFacade.
                dateOfNextRepositionByProduct(Integer.parseInt(productId)).getTime());
    }

    @GET
    @Path("model")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByModel(@Context HttpHeaders headers) {
        return productFacade.allProductsByModel(headers.getRequestHeaders().getFirst("model"));
    }

    @GET
    @Path("brand")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByBrand(@Context HttpHeaders headers) {
        return productFacade.allProductsByBrand(headers.getRequestHeaders().getFirst("brand"));
    }

    @GET
    @Path("version")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByVersion(@Context HttpHeaders headers) {
        return productFacade.allProductsByVersion(headers.getRequestHeaders().getFirst("version"));
    }

    @GET
    @Path("designation")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByDesignation(@Context HttpHeaders headers) {
        String brand = headers.getRequestHeaders().getFirst("brand");
        String version = headers.getRequestHeaders().getFirst("version");
        String model = headers.getRequestHeaders().getFirst("model");
        return productFacade.allProductsByBrandVersionModel(brand, version, model);
    }

    @GET
    @Path("category")
    @Produces({"application/xml", "application/json"})
    public List<Product> findProductsByCategory(@Context HttpHeaders headers) {
        return productFacade.allProductsByCategory(headers.getRequestHeaders().getFirst("category"));
    }
}
