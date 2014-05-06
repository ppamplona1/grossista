/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Pedro
 */
@Embeddable
public class OrderHasProductPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_product_id")
    private int productproductid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_order_id")
    private int orderOrderId;

    public OrderHasProductPK() {
    }

    public OrderHasProductPK(int productproductid, int orderOrderId) {
        this.productproductid = productproductid;
        this.orderOrderId = orderOrderId;
    }

    public int getProductproductid() {
        return productproductid;
    }

    public void setProductproductid(int productproductid) {
        this.productproductid = productproductid;
    }

    public int getOrderOrderId() {
        return orderOrderId;
    }

    public void setOrderOrderId(int orderOrderId) {
        this.orderOrderId = orderOrderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productproductid;
        hash += (int) orderOrderId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasProductPK)) {
            return false;
        }
        OrderHasProductPK other = (OrderHasProductPK) object;
        if (this.productproductid != other.productproductid) {
            return false;
        }
        if (this.orderOrderId != other.orderOrderId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.uc.dei.aor.projeto7.grupoc.rest.products.OrderHasProductPK[ productproductid=" + productproductid + ", orderOrderId=" + orderOrderId + " ]";
    }
    
}
