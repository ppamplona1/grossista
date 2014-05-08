/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import teste.OrderHasProductPK;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "order_has_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderHasProduct.findAll", query = "SELECT o FROM OrderHasProduct o"),
    @NamedQuery(name = "OrderHasProduct.findByPrice", query = "SELECT o FROM OrderHasProduct o WHERE o.price = :price"),
    @NamedQuery(name = "OrderHasProduct.findByQuantity", query = "SELECT o FROM OrderHasProduct o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "OrderHasProduct.findByProductproductid", query = "SELECT o FROM OrderHasProduct o WHERE o.orderHasProductPK.productproductid = :productproductid"),
    @NamedQuery(name = "OrderHasProduct.findByOrderOrderId", query = "SELECT o FROM OrderHasProduct o WHERE o.orderHasProductPK.orderOrderId = :orderOrderId")})
public class OrderHasProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrderHasProductPK orderHasProductPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;

    public OrderHasProduct() {
    }

    public OrderHasProduct(OrderHasProductPK orderHasProductPK) {
        this.orderHasProductPK = orderHasProductPK;
    }

    public OrderHasProduct(int productproductid, int orderOrderId) {
        this.orderHasProductPK = new OrderHasProductPK(productproductid, orderOrderId);
    }

    public OrderHasProductPK getOrderHasProductPK() {
        return orderHasProductPK;
    }

    public void setOrderHasProductPK(OrderHasProductPK orderHasProductPK) {
        this.orderHasProductPK = orderHasProductPK;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        return "pt.uc.dei.aor.projeto7.grupoc.rest.products.OrderHasProduct[ orderHasProductPK=" + orderHasProductPK + " ]";
    }

}
