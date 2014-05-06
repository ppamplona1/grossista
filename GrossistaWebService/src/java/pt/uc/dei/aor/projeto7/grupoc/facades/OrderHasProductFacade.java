/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.entities.OrderHasProduct;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;

/**
 *
 * @author Pedro
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

    public OrderHasProduct orderHasProduct(int quantity, double priceOfUnity, Product p, Order1 o) {
        OrderHasProduct ohp = new OrderHasProduct();
        ohp.setQuantity(quantity);
        //ohp.setProduct(p);
        ohp.setPrice(priceOfUnity);
        //ohp.setOrder1(o);
        create(ohp);  // create é um método da AbstractFacade
        // em.persist(ohp); seria outra forma de fazer o mesmo que a linha de cima
        return ohp;
    }

}
