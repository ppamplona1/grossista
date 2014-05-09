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
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.UserNotFoundException;
import pt.uc.dei.aor.projeto7.grupoc.facades.ClientFacade;
import pt.uc.dei.aor.projeto7.grupoc.facades.ProductFacade;

/**
 *
 * @author User
 */
@WebService(serviceName = "ProductsServiceSoap")
@Stateless()
public class ProductsServiceSoap {

    @EJB
    private ProductFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @EJB
    private ClientFacade ejbClient;

    @WebMethod(operationName = "create")
    public void create(@WebParam(name = "entity") Product entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    public void edit(@WebParam(name = "entity") Product entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    public void remove(@WebParam(name = "entity") Product entity, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Product find(@WebParam(name = "id") Object id, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Product> findAll(@WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "allProductsByBrand")
    public List<Product> allProductsByBrand(@WebParam(name = "marca") String marca, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.allProductsByBrand(marca);
    }

    @WebMethod(operationName = "allProductsByModel")

    public List<Product> allProductsByModel(@WebParam(name = "modelo") String modelo, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.allProductsByModel(modelo);
    }

    @WebMethod(operationName = "allProductsByVersion")
    public List<Product> allProductsByVersion(@WebParam(name = "versao") String versao,
            @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.allProductsByVersion(versao);
    }

    @WebMethod(operationName = "allProductsByDesignation")
    public List<Product> allProductsByDesignation(@WebParam(name = "designacao") String designacao, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.allProductsByDesignation(designacao);
    }

    @WebMethod(operationName = "allProductsByBrandVersionModel")
    public List<Product> allProductsByBrandVersionModel(@WebParam(name = "brand") String brand, @WebParam(name = "version") String version, @WebParam(name = "model") String model, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.allProductsByBrandVersionModel(brand, version, model);
    }

    @WebMethod(operationName = "allProductsByCategory")
    public List<Product> allProductsByCategory(@WebParam(name = "categorys") String categorys, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.allProductsByCategory(categorys);
    }

    @WebMethod(operationName = "stockQtyByProduct")
    public Integer stockQtyByProduct(@WebParam(name = "produto") Product produto, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.stockQtyByProduct(produto);
    }

    @WebMethod(operationName = "stockOKProduct")
    public boolean stockOKProduct(@WebParam(name = "productId") Integer productId, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.stockOKProduct(productId);
    }

    @WebMethod(operationName = "dateOfNextRepositionByProduct")
    public Date dateOfNextRepositionByProduct(@WebParam(name = "productId") Integer productId, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.dateOfNextRepositionByProduct(productId);
    }

    @WebMethod(operationName = "getProduct")
    public Product getProduct(@WebParam(name = "productID") Integer productID, @WebParam(name = "apiKey") String apikey) throws UserNotFoundException {
        ejbClient.findClientByApiKey(apikey);
        return ejbRef.getProduct(productID);
    }

}
