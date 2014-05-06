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
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;
import pt.uc.dei.aor.projeto7.grupoc.facades.ProductFacade;

/**
 *
 * @author User
 */
@WebService(serviceName = "ProductsSoap")
@Stateless()
public class ProductsSoap {
    @EJB
    private ProductFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Product entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Product entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Product entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Product find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Product> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Product> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "allProductsByBrand")
    public List<Product> allProductsByBrand(@WebParam(name = "marca") String marca) {
        return ejbRef.allProductsByBrand(marca);
    }

    @WebMethod(operationName = "allProductsByModel")
    public List<Product> allProductsByModel(@WebParam(name = "modelo") String modelo) {
        return ejbRef.allProductsByModel(modelo);
    }

    @WebMethod(operationName = "allProductsByVersion")
    public List<Product> allProductsByVersion(@WebParam(name = "versao") String versao) {
        return ejbRef.allProductsByVersion(versao);
    }

    @WebMethod(operationName = "allProductsByDesignation")
    public List<Product> allProductsByDesignation(@WebParam(name = "designacao") String designacao) {
        return ejbRef.allProductsByDesignation(designacao);
    }

    @WebMethod(operationName = "allProductsByBrandVersionModel")
    public List<Product> allProductsByBrandVersionModel(@WebParam(name = "brand") String brand, @WebParam(name = "version") String version, @WebParam(name = "model") String model) {
        return ejbRef.allProductsByBrandVersionModel(brand, version, model);
    }

    @WebMethod(operationName = "allProductsByCategory")
    public List<Product> allProductsByCategory(@WebParam(name = "categorys") String categorys) {
        return ejbRef.allProductsByCategory(categorys);
    }

    @WebMethod(operationName = "stockQtyByProduct")
    public Integer stockQtyByProduct(@WebParam(name = "produto") Product produto) {
        return ejbRef.stockQtyByProduct(produto);
    }

    @WebMethod(operationName = "stockOKProduct")
    public boolean stockOKProduct(@WebParam(name = "productId") Integer productId) {
        return ejbRef.stockOKProduct(productId);
    }

    @WebMethod(operationName = "dateOfNextRepositionByProduct")
    public Date dateOfNextRepositionByProduct(@WebParam(name = "productId") Integer productId) {
        return ejbRef.dateOfNextRepositionByProduct(productId);
    }

    @WebMethod(operationName = "getProduct")
    public Product getProduct(@WebParam(name = "productID") Integer productID) {
        return ejbRef.getProduct(productID);
    }

}
