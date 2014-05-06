/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "order_has_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHasProduct.findAll", query = "SELECT o FROM OrderHasProduct o"),
    @NamedQuery(name = "OrderHasProduct.findByOrderOrderId", query = "SELECT o FROM OrderHasProduct o WHERE o.orderHasProductPK.orderOrderId = :orderOrderId"),
    @NamedQuery(name = "OrderHasProduct.findByProductproductid", query = "SELECT o FROM OrderHasProduct o WHERE o.orderHasProductPK.productproductid = :productproductid"),
    @NamedQuery(name = "OrderHasProduct.findByQuantity", query = "SELECT o FROM OrderHasProduct o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "OrderHasProduct.findByPrice", query = "SELECT o FROM OrderHasProduct o WHERE o.price = :price")})
public class OrderHasProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderHasProductPK orderHasProductPK;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @NotNull
    @Column(name = "price")
    private double price;
    @JoinColumn(name = "Product_product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "order_order_id", referencedColumnName = "order_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order1 order1;

    public OrderHasProduct() {
    }

    public OrderHasProduct(OrderHasProductPK orderHasProductPK) {
        this.orderHasProductPK = orderHasProductPK;
    }

    public OrderHasProduct(OrderHasProductPK orderHasProductPK, int quantity, double price) {
        this.orderHasProductPK = orderHasProductPK;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderHasProduct(int orderOrderId, int productproductid) {
        this.orderHasProductPK = new OrderHasProductPK(orderOrderId, productproductid);
    }

    public OrderHasProductPK getOrderHasProductPK() {
        return orderHasProductPK;
    }

    public void setOrderHasProductPK(OrderHasProductPK orderHasProductPK) {
        this.orderHasProductPK = orderHasProductPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order1 getOrder1() {
        return order1;
    }

    public void setOrder1(Order1 order1) {
        this.order1 = order1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderHasProductPK != null ? orderHasProductPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasProduct)) {
            return false;
        }
        OrderHasProduct other = (OrderHasProduct) object;
        if ((this.orderHasProductPK == null && other.orderHasProductPK != null) || (this.orderHasProductPK != null && !this.orderHasProductPK.equals(other.orderHasProductPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.uc.dei.aor.projeto7.grupoc.entities.OrderHasProduct[ orderHasProductPK=" + orderHasProductPK + " ]";
    }

}
