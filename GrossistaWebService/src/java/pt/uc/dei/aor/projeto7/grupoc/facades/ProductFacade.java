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
 * @author To
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

        Query query = em.createNamedQuery("Product.findByStock");
        query.setParameter("product", produto);

        Integer prod = 0;

        try {

            prod = (Integer) query.getSingleResult();

        } catch (NoResultException e) {
            //
        }
        return prod;
    }

    public boolean stockOKProduct(Product produto) {

        if (stockQtyByProduct(produto) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Date dateOfNextRepositionByProduct(Product produto) {

        Query query = em.createNamedQuery("Product.findDateOfNextRepositionByProduct");
        query.setParameter("product", produto);

        Date dateReposition = null;

        try {

            dateReposition = (Date) query.getSingleResult();

        } catch (NoResultException e) {
            //
        }
        return dateReposition;
    }

}
