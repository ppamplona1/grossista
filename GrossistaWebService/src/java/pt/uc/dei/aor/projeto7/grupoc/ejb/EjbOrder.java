/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.uc.dei.aor.projeto7.grupoc.ejb;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
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

    public void createOrderAndOrderHasProduct(int clientId, HashMap<Product, Integer> encom) throws CreateOrderException {

        GregorianCalendar expectedDate = getExpectedDate();

        Order1 order = new Order1();

        order.setClientclientid(cf.find(clientId));

        Date expectedDateConversion = new Date(expectedDate.getTimeInMillis());

        order.setExpectedDate(expectedDateConversion);

        try {
            of.create(order);
        } catch (TransactionRequiredException ex) {

            Logger.getLogger(EjbOrder.class.getName(), ex.getMessage());
            throw new CreateOrderException();
        }

        OrderHasProduct oHasProduct = new OrderHasProduct();

        Integer qty;

        for (Product key : encom.keySet()) {

            qty = encom.get(key);

            oHasProduct.setQuantity(qty);
            oHasProduct.setProduct(key);
            oHasProduct.setOrder1(order);

            try {
                ohpf.create(oHasProduct);
            } catch (TransactionRequiredException ex) {
                //mensagem deverá diferente e ser melhorada
                Logger.getLogger(EjbOrder.class.getName(), ex.getMessage());
                throw new CreateOrderException();
            }

        }
    }

    // A encomenda e entregue ao cliente em 3 dias uteis, caso os produtos estejam em stock.
    // Este metodo da-nos a data esperada de entrega da encomenda, caso todos os produtos encomendados estejam disponiveis.
    public GregorianCalendar getExpectedDate() {

        GregorianCalendar todayDate = new GregorianCalendar();
        GregorianCalendar expectedDate = new GregorianCalendar();

        int dayOfweek = todayDate.get(GregorianCalendar.DAY_OF_WEEK);

        //No GregorianCalendar domingo corresponde ao dia da semana 1, segunda ao dia 2, ..., sabado ao dia 7
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

    public Date getExpectedOrderDate(Order1 order) {

        return order.getExpectedDate();
    }

//    public void removeOrder(Order1 order) {
//
//        of.remove(order);
//    }
//
//    //  ?????????????????????????????????????????????????????????????
//    public void editOrder(Order1 order) {
//
//        of.edit(order);
//    }
//    public List<Order1> findAllOrders(Integer IdClient) {
//        return of.allOrdersByClient(IdClient);
//    }
}
