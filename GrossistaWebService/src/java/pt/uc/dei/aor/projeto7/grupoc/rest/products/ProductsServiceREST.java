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
    @Produces({"application/xml", "application/json"})
    public List<Product> findAll() {
        return productFacade.findAll();
    }

}
