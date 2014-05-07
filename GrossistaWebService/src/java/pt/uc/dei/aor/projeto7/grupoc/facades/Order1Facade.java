/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.aor.projeto7.grupoc.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;

/**
 *
 * @author Pedro
 */
@Stateless
public class Order1Facade extends AbstractFacade<Order1> {

    @PersistenceContext(unitName = "GrossistaWebServicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Order1Facade() {
        super(Order1.class);
    }

    public List<Order1> allOrdersByClient(Integer IdClient) {

        Query query = em.createNamedQuery("Order1.findByClientId");
        query.setParameter("idCliente", IdClient);

        List<Order1> ordersList = null;

        try {
            ordersList = query.getResultList();
        } catch (NoResultException e) {
            //
        }
        return ordersList;
    }

}
