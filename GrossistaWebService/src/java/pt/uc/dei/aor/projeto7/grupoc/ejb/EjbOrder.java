/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.aor.projeto7.grupoc.ejb;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.TransactionRequiredException;
import pt.uc.dei.aor.projeto7.grupoc.entities.Order1;
import pt.uc.dei.aor.projeto7.grupoc.entities.OrderHasProduct;
import pt.uc.dei.aor.projeto7.grupoc.entities.Product;
import pt.uc.dei.aor.projeto7.grupoc.exceptions.CreateOrderException;
import pt.uc.dei.aor.projeto7.grupoc.facades.ClientFacade;
import pt.uc.dei.aor.projeto7.grupoc.facades.Order1Facade;
import pt.uc.dei.aor.projeto7.grupoc.facades.OrderHasProductFacade;

/**
 *
 * @author To
 */
@Stateless
public class EjbOrder {

    @Inject
    private Order1Facade of;

    @Inject
    private OrderHasProductFacade ohpf;

    @Inject
    private ClientFacade cf;

    public void createOrder(int clientId, HashMap<Product, Integer> encom) throws CreateOrderException {

        GregorianCalendar expectedDate = getExpectedDate();

        Order1 order = new Order1();

        cf.find(clientId);

        order.setClientclientid(cf.find(clientId));

        Date expectedDateConv = new Date(expectedDate.getTimeInMillis());

        order.setExpectedDate(expectedDateConv);

        try {
            of.create(order);
        } catch (TransactionRequiredException ex) {

            Logger.getLogger(EjbOrder.class.getName(), ex.getMessage());
            throw new CreateOrderException();
        }

        OrderHasProduct ohasProduct = new OrderHasProduct();

        Set<Product> product = encom.keySet();
        for (Product chave : product) {

            ohasProduct.setOrder1(order);

//            ohasProduct.setProduct(chave.prod);
//            ohasProduct.setProduct(product);
        }
    }

    public GregorianCalendar getExpectedDate() {

        GregorianCalendar actualDate = new GregorianCalendar();
        GregorianCalendar expectedDate = new GregorianCalendar();

        int dayOfweek = actualDate.get(GregorianCalendar.DAY_OF_WEEK);

        switch (dayOfweek) {

            case 1:
            case 2:
            case 3:
                expectedDate.add(GregorianCalendar.DAY_OF_MONTH, 3);
                break;

            case 4:
            case 5:
            case 6:
                expectedDate.add(GregorianCalendar.DAY_OF_MONTH, 5);
                break;

            case 7:
                expectedDate.add(GregorianCalendar.DAY_OF_MONTH, 4);
                break;

        }
        return expectedDate;
    }

}
