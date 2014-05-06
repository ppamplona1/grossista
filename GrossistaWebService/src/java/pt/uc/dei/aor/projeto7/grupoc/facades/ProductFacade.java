/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.facades;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;

/**
 *
 * @author Pedro
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> {

    @PersistenceContext(unitName = "GrossistaWebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    public List<Product> allProductsByBrand(String marca) {
        Query query = em.createNamedQuery("Product.findByBrand");

        return query.setParameter("brand", marca).getResultList();
    }

    public List<Product> allProductsByModel(String modelo) {
        Query query = em.createNamedQuery("Product.findByModel");

        return query.setParameter("model", modelo).getResultList();
    }

    public List<Product> allProductsByVersion(String versao) {
        Query query = em.createNamedQuery("Product.findByVersion");

        return query.setParameter("version", versao).getResultList();
    }

    public List<Product> allProductsByDesignation(String designacao) {
        Query query = em.createNamedQuery("Product.findByDesignation");

        return query.setParameter("designation", designacao).getResultList();
    }

    public List<Product> allProductsByBrandVersionModel(String brand, String version, String model) {
        return em.createNamedQuery("Product.findByModelVersionBrand").
                setParameter("brand", brand).setParameter("model", model).
                setParameter("version", version).getResultList();
    }

    public List<Product> allProductsByCategory(String categorys) {

        Query query = em.createNamedQuery("Product.findByCategory");
        query.setParameter("category", categorys);

        List<Product> productList = null;

        try {
            productList = query.getResultList();
        } catch (NoResultException e) {
            //
        }
        return productList;
    }

    public Integer stockQtyByProduct(Product produto) {

        Query query = em.createNamedQuery("Product.findStockByProduct");
        query.setParameter("product", produto);

        Integer prod = 0;

        try {

            prod = (Integer) query.getSingleResult();

        } catch (NoResultException e) {
            //
        }
        return prod;
    }

    public boolean stockOKProduct(Integer productId) {

        if (stockQtyByProduct(em.find(Product.class, productId)) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Date dateOfNextRepositionByProduct(Integer productId) {

        Query query = em.createNamedQuery("Product.findDateOfNextRepositionByProduct");
        query.setParameter("product", em.find(Product.class, productId));

        Date dateReposition = null;

        try {

            dateReposition = (Date) query.getSingleResult();

        } catch (NoResultException e) {
            //
        }
        return dateReposition;
    }

    public Product getProduct(Integer productID) {
        return em.find(Product.class, productID);
    }

}
