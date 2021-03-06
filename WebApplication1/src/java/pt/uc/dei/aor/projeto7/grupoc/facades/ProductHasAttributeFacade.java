/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javaeetutorial.customer.resource.ProductHasAttribute;

/**
 *
 * @author Pedro
 */
@Stateless
public class ProductHasAttributeFacade extends AbstractFacade<ProductHasAttribute> {
    @PersistenceContext(unitName = "GrossistaWebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductHasAttributeFacade() {
        super(ProductHasAttribute.class);
    }
    
}
