/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.ejb;

import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.UserNotFoundException;
import pt.uc.dei.aor.projeto7.grupoc.facades.ClientFacade;
import pt.uc.dei.aor.projeto7.grupoc.facades.Order1Facade;
import pt.uc.dei.aor.projeto7.grupoc.facades.ProductFacade;
import pt.uc.dei.aor.projeto7.grupoc.rest.clients.ClientsServiceREST;
import pt.uc.dei.aor.projeto7.grupoc.rest.orders.OrdersServiceRest;
import pt.uc.dei.aor.projeto7.grupoc.rest.products.ProductsServiceREST;

/**
 *
 * @author User
 */
@Stateless
public class ServiceEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Inject
    private ClientFacade clientfacade;

    @Inject
    private Order1Facade orderfacade;

    @Inject
    private ProductFacade productFacade;

    public Collection<Order1> ordersListClient(@Context HttpHeaders headers, String clientId) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apikey"));

            return clientfacade.find(Integer.parseInt(clientId)).getOrder1Collection();
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ClientsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public boolean createOrder(@Context HttpHeaders headers) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apikey"));
            String jsonEntity = headers.getRequestHeaders().getFirst("order1");
            orderfacade.create(new Gson().fromJson(jsonEntity, Order1.class));
            return true;
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public boolean editOrder(@Context HttpHeaders headers) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apikey"));
            String jsonEntity = headers.getRequestHeaders().getFirst("order1");
            orderfacade.edit(new Gson().fromJson(jsonEntity, Order1.class));
            return true;
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public boolean removeOrder(@Context HttpHeaders headers, String orderId) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apikey"));

            orderfacade.remove(orderfacade.find(Integer.parseInt(orderId)));
            return true;
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public Order1 findOrder(@Context HttpHeaders headers, String orderId) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apikey"));

            return orderfacade.find(Integer.parseInt(orderId));
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public Date getExpectedDateFromEdition(@Context HttpHeaders headers, String orderId) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apikey"));

            return orderfacade.find(Integer.parseInt(orderId)).getExpectedDate();
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public List<Order1> findAllOrders(@Context HttpHeaders headers) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apikey"));
            return orderfacade.findAll();
        } catch (UserNotFoundException ex) {
            Logger.getLogger(OrdersServiceRest.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public List<Product> findAllProducts(@Context HttpHeaders headers) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));
            return productFacade.findAll();
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

    }

    public Product getProduct(@Context HttpHeaders headers, String productId) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));

            return productFacade.getProduct(Integer.parseInt(productId));
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public int getStockProduct(@Context HttpHeaders headers, String productId) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));

            return productFacade.stockQtyByProduct(productFacade.
                    find(Integer.parseInt(productId)));
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public boolean availableProduct(@Context HttpHeaders headers, String productId) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));

            return productFacade.stockOKProduct(Integer.parseInt(productId));
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public String dateOfNextRepositionProduct(@Context HttpHeaders headers, String productId) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));

            return new SimpleDateFormat("dd-MM-yyyy").format(productFacade.
                    dateOfNextRepositionByProduct(Integer.parseInt(productId)).getTime());
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public List<Product> findProductsByModel(@Context HttpHeaders headers, String model) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));
            return productFacade.allProductsByModel(model);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public List<Product> findProductsByBrand(@Context HttpHeaders headers, String brand) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));
            return productFacade.allProductsByBrand(brand);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public List<Product> findProductsByVersion(@Context HttpHeaders headers, String version) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));
            return productFacade.allProductsByVersion(version);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public List<Product> findProductsByDesignation(@Context HttpHeaders headers) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));
            String brand = headers.getRequestHeaders().getFirst("brand");
            String version = headers.getRequestHeaders().getFirst("version");
            String model = headers.getRequestHeaders().getFirst("model");
            return productFacade.allProductsByBrandVersionModel(brand, version, model);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

    public List<Product> findProductsByCategory(@Context HttpHeaders headers, String category) {
        try {
            clientfacade.findClientByApiKey(headers.getRequestHeaders().getFirst("apiKey"));
            return productFacade.allProductsByCategory(category);
        } catch (UserNotFoundException ex) {
            Logger.getLogger(ProductsServiceREST.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }
    }

}
