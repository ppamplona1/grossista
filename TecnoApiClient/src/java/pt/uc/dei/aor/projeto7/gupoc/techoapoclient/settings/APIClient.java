/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.gupoc.techoapoclient.settings;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import pt.uc.dei.aor.projeto7.gupoc.techoapoclient.grossistawebservice.soap.Product;
import pt.uc.dei.aor.projeto7.gupoc.techoapoclient.grossistawebservice.soap.orders.Order1;

/**
 *
 * @author User
 */
public interface APIClient {

    public Collection<Order1> ordersListClient();

    public boolean create();

    public boolean removeOrder();

    public Order1 findOrder();

    public Date getExpectedDateFromEdition();

    public List<Order1> findAllOrders();

    public List<Product> findAllProducts();

    public Product getProduct();

    public int getStockProduct();

    public boolean availableProduct();

    public String dateOfNextRepositionProduct();

    public List<Product> findProductsByModel();

    public List<Product> findProductsByBrand();

    public List<Product> findProductsByVersion();

    public List<Product> findProductsByDesignation();

    public List<Product> findProductsByCategory();

}
