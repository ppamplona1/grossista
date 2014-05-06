/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.rest.products;

import java.util.Date;
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
import javax.ws.rs.core.MediaType;
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

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> findAll() {
        return productFacade.findAll();

    }

    @GET
    @Path("{productId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Product getProduct(@PathParam("productId") String productId) {

        return productFacade.getProduct(Integer.parseInt(productId));
    }

    @GET
    @Path("{productId}/stock")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getStockProduct(@PathParam("productId") String productId) {

        return "<stock>" + productFacade.stockQtyByProduct(productFacade.
                find(Integer.parseInt(productId))) + "</stock>";
    }

    @GET
    @Path("{productId}/available")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String availableProduct(@PathParam("productId") String productId) {

        return "<stock>" + productFacade.stockOKProduct(Integer.parseInt(productId)) + "</stock>";
    }

    @GET
    @Path("{productId}/dateOfNextReposition")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Date dateOfNextRepositionProduct(@PathParam("productId") String productId) {

        return productFacade.dateOfNextRepositionByProduct(Integer.parseInt(productId));
    }

    @GET
    @Path("model/{model}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> findProductsByModel(@PathParam("model") String model) {
        return productFacade.allProductsByModel(model);
    }

    @GET
    @Path("brand/{brand}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> findProductsByBrand(@PathParam("brand") String brand) {
        return productFacade.allProductsByBrand(brand);
    }

    @GET
    @Path("version/{version}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> findProductsByVersion(@PathParam("version") String version) {
        return productFacade.allProductsByVersion(version);
    }

    @GET
    @Path("brand/{brand}/model/{model}/version/{version}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> findProductsByVersion(@PathParam("model") String model,
            @PathParam("version") String version, @PathParam("brand") String brand) {
        return productFacade.allProductsByBrandVersionModel(brand, version, model);
    }

    @GET
    @Path("category/{category}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> findProductsByCategory(@PathParam("category") String category) {
        return productFacade.allProductsByCategory(category);
    }

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

}
