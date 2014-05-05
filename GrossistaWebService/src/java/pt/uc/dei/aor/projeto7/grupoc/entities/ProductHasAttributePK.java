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
public class ProductHasAttributePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "Product_product_id")
    private int productproductid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Attribute_attribute_id")
    private int attributeattributeid;

    public ProductHasAttributePK() {
    }

    public ProductHasAttributePK(int productproductid, int attributeattributeid) {
        this.productproductid = productproductid;
        this.attributeattributeid = attributeattributeid;
    }

    public int getProductproductid() {
        return productproductid;
    }

    public void setProductproductid(int productproductid) {
        this.productproductid = productproductid;
    }

    public int getAttributeattributeid() {
        return attributeattributeid;
    }

    public void setAttributeattributeid(int attributeattributeid) {
        this.attributeattributeid = attributeattributeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productproductid;
        hash += (int) attributeattributeid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductHasAttributePK)) {
            return false;
        }
        ProductHasAttributePK other = (ProductHasAttributePK) object;
        if (this.productproductid != other.productproductid) {
            return false;
        }
        if (this.attributeattributeid != other.attributeattributeid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.uc.dei.aor.projeto7.grupoc.entities.ProductHasAttributePK[ productproductid=" + productproductid + ", attributeattributeid=" + attributeattributeid + " ]";
    }

}
