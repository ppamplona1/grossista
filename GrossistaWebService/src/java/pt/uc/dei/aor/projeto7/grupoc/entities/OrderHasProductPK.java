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
 * @author User
 */
@Embeddable
public class OrderHasProductPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_order_id")
    private int orderOrderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_product_id")
    private int productproductid;

    public OrderHasProductPK() {
    }

    public OrderHasProductPK(int orderOrderId, int productproductid) {
        this.orderOrderId = orderOrderId;
        this.productproductid = productproductid;
    }

    public int getOrderOrderId() {
        return orderOrderId;
    }

    public void setOrderOrderId(int orderOrderId) {
        this.orderOrderId = orderOrderId;
    }

    public int getProductproductid() {
        return productproductid;
    }

    public void setProductproductid(int productproductid) {
        this.productproductid = productproductid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orderOrderId;
        hash += (int) productproductid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderHasProductPK)) {
            return false;
        }
        OrderHasProductPK other = (OrderHasProductPK) object;
        if (this.orderOrderId != other.orderOrderId) {
            return false;
        }
        if (this.productproductid != other.productproductid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.uc.dei.aor.projeto7.grupoc.entities.OrderHasProductPK[ orderOrderId=" + orderOrderId + ", productproductid=" + productproductid + " ]";
    }

}
