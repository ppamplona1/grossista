/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.aor.projeto7.grupoc.soap;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pt.uc.dei.aor.projeto7.grupoc.entities.Client;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.NotRegistedEmailException;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.UserNotFoundException;
import pt.uc.dei.aor.projeto7.grupoc.facades.ClientFacade;
import pt.uc.dei.aor.projeto7.grupoc.facades.Order1Facade;
import pt.uc.dei.aor.projeto7.grupoc.facades.ProductFacade;

/**
 *
 * @author User
 */
@WebService(serviceName = "TechoApiSoaoService")
@Stateless()
public class TechoApiSoapService {

    @EJB
    private ProductFacade ejbProduct;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @EJB
    private ClientFacade ejbClient;

    @Inject
    private Order1Facade ejbOrder;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "findAllP")
    public List<Product> findAllP(@WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.findAll();
    }

    @WebMethod(operationName = "findProductsByBrand")
    public List<Product> findProductsByBrand(@WebParam(name = "marca") String marca, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.allProductsByBrand(marca);
    }

    @WebMethod(operationName = "findProductsByModel")

    public List<Product> findProductsByModel(@WebParam(name = "modelo") String modelo, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.allProductsByModel(modelo);
    }

    @WebMethod(operationName = "findProductsByVersion")
    public List<Product> findProductsByVersion(@WebParam(name = "versao") String versao,
            @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.allProductsByVersion(versao);
    }

//    @WebMethod(operationName = "allProductsByDesignation")
//    public List<Product> allProductsByDesignation(@WebParam(name = "designacao") String designacao, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
//        ejbClient.findClientByApiKey(apikey);
//        return ejbProduct.allProductsByDesignation(designacao);
//    }
    @WebMethod(operationName = "findProductsByDesignation")
    public List<Product> findProductsByDesignation(@WebParam(name = "brand") String brand, @WebParam(name = "version") String version, @WebParam(name = "model") String model, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.allProductsByBrandVersionModel(brand, version, model);
    }

    @WebMethod(operationName = "findProductsByCategory")
    public List<Product> findProductsByCategory(@WebParam(name = "categorys") String categorys, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.allProductsByCategory(categorys);
    }

    @WebMethod(operationName = "getStockProduct")
    public Integer getStockProduct(@WebParam(name = "produto") Product produto, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.stockQtyByProduct(produto);
    }

    @WebMethod(operationName = "availableProduct")
    public boolean availableProduct(@WebParam(name = "productId") Integer productId, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.stockOKProduct(productId);
    }

    @WebMethod(operationName = "dateOfNextRepositionProduct")
    public Date dateOfNextRepositionProduct(@WebParam(name = "productId") Integer productId, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.dateOfNextRepositionByProduct(productId);
    }

    @WebMethod(operationName = "getProduct")
    public Product getProduct(@WebParam(name = "productID") Integer productID, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbProduct.getProduct(productID);
    }

    @WebMethod(operationName = "createO")
    public void createO(@WebParam(name = "entityOrder") Order1 entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbOrder.create(entity);
    }

    @WebMethod(operationName = "editO")
    public void editO(@WebParam(name = "entityOrder") Order1 entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbOrder.edit(entity);
    }

    @WebMethod(operationName = "removeO")
    public void removeO(@WebParam(name = "entityOrder") Order1 entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbOrder.remove(entity);
    }

    @WebMethod(operationName = "findO")
    public Order1 findO(@WebParam(name = "id") Object id, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbOrder.find(id);
    }

    @WebMethod(operationName = "findAllO")
    public List<Order1> findAllO(@WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbOrder.findAll();
    }

    @WebMethod(operationName = "ordersListClient")
    public List<Order1> ordersListClient(@WebParam(name = "IdClient") Integer IdClient, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbOrder.allOrdersByClient(IdClient);
    }

    @WebMethod(operationName = "getUserbyEmail")
    public Client getUserbyEmail(@WebParam(name = "email") String email, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException, NotRegistedEmailException {
        ejbClient.findClientByApiKey(apikey);
        return ejbClient.getUserbyEmail(email);
    }

    public Client findClientByApiKey(String apiKey) throws UserNotFoundException {
        return ejbClient.findClientByApiKey(apiKey);
    }
}
