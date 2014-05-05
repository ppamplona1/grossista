/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.aor.projeto7.grupoc.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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

    public List<Product> allProductsByBrand(String marca){       
        Query query = em.createNamedQuery("Product.findByBrand");
        
        return query.setParameter("brand", marca).getResultList();
    }
    
    public List<Product> allProductsByModel(String modelo){
        Query query = em.createNamedQuery("Product.findByModel");
        
        return query.setParameter("model", modelo).getResultList();
    }
    
    public List<Product> allProductsByVersion(String versao){
        Query query = em.createNamedQuery("Product.findByVersion");
        
        return query.setParameter("version", versao).getResultList();
    }
    
    public List<Product> allProductsByDesignation(String designacao){
        Query query = em.createNamedQuery("Product.findByDesignation");
        
        return query.setParameter("designation", designacao).getResultList();
    }
}
