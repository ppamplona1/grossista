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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "product_has_attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductHasAttribute.findAll", query = "SELECT p FROM ProductHasAttribute p"),
    @NamedQuery(name = "ProductHasAttribute.findByValue", query = "SELECT p FROM ProductHasAttribute p WHERE p.value = :value"),
    @NamedQuery(name = "ProductHasAttribute.findByProductproductid", query = "SELECT p FROM ProductHasAttribute p WHERE p.productHasAttributePK.productproductid = :productproductid"),
    @NamedQuery(name = "ProductHasAttribute.findByAttributeattributeid", query = "SELECT p FROM ProductHasAttribute p WHERE p.productHasAttributePK.attributeattributeid = :attributeattributeid")})
public class ProductHasAttribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductHasAttributePK productHasAttributePK;
    @Size(max = 255)
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "Product_product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;
    @JoinColumn(name = "Attribute_attribute_id", referencedColumnName = "attribute_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Attribute attribute;

    public ProductHasAttribute() {
    }

    public ProductHasAttribute(ProductHasAttributePK productHasAttributePK) {
        this.productHasAttributePK = productHasAttributePK;
    }

    public ProductHasAttribute(int productproductid, int attributeattributeid) {
        this.productHasAttributePK = new ProductHasAttributePK(productproductid, attributeattributeid);
    }

    public ProductHasAttributePK getProductHasAttributePK() {
        return productHasAttributePK;
    }

    public void setProductHasAttributePK(ProductHasAttributePK productHasAttributePK) {
        this.productHasAttributePK = productHasAttributePK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productHasAttributePK != null ? productHasAttributePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductHasAttribute)) {
            return false;
        }
        ProductHasAttribute other = (ProductHasAttribute) object;
        if ((this.productHasAttributePK == null && other.productHasAttributePK != null) || (this.productHasAttributePK != null && !this.productHasAttributePK.equals(other.productHasAttributePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.uc.dei.aor.projeto7.grupoc.rest.products.ProductHasAttribute[ productHasAttributePK=" + productHasAttributePK + " ]";
    }
    
}
