/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "attribute")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attribute.findAll", query = "SELECT a FROM Attribute a"),
    @NamedQuery(name = "Attribute.findByAttributeId", query = "SELECT a FROM Attribute a WHERE a.attributeId = :attributeId"),
    @NamedQuery(name = "Attribute.findByAttributeName", query = "SELECT a FROM Attribute a WHERE a.attributeName = :attributeName")})
public class Attribute implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "attribute_id")
    private Integer attributeId;
    @Size(max = 255)
    @Column(name = "attribute_name")
    private String attributeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "attribute")
    private Collection<ProductHasAttribute> productHasAttributeCollection;

    public Attribute() {
    }

    public Attribute(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    @XmlTransient
    public Collection<ProductHasAttribute> getProductHasAttributeCollection() {
        return productHasAttributeCollection;
    }

    public void setProductHasAttributeCollection(Collection<ProductHasAttribute> productHasAttributeCollection) {
        this.productHasAttributeCollection = productHasAttributeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attributeId != null ? attributeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attribute)) {
            return false;
        }
        Attribute other = (Attribute) object;
        if ((this.attributeId == null && other.attributeId != null) || (this.attributeId != null && !this.attributeId.equals(other.attributeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.uc.dei.aor.projeto7.grupoc.rest.products.Attribute[ attributeId=" + attributeId + " ]";
    }
    
}
