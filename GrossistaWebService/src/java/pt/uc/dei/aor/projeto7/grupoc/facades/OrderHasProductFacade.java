/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.aor.projeto7.grupoc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.uc.dei.aor.projeto7.grupoc.entities.OrderHasProduct;

/**
 *
 * @author To
 */
@Stateless
public class OrderHasProductFacade extends AbstractFacade<OrderHasProduct> {

    @PersistenceContext(unitName = "GrossistaWebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrderHasProductFacade() {
        super(OrderHasProduct.class);

    }

}
