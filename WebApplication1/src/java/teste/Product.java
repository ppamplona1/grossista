/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teste;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pedro
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByBrand", query = "SELECT p FROM Product p WHERE p.brand = :brand"),
    @NamedQuery(name = "Product.findByModel", query = "SELECT p FROM Product p WHERE p.model = :model"),
    @NamedQuery(name = "Product.findByVersion", query = "SELECT p FROM Product p WHERE p.version = :version"),
    @NamedQuery(name = "Product.findByDesignation", query = "SELECT p FROM Product p WHERE p.version = :version OR p.brand = :brand OR p.model = :model"),
    @NamedQuery(name = "Product.findByModelVersionBrand", query = "SELECT p FROM Product p WHERE p.version = :version AND p.brand = :brand AND p.model = :model"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category = :category"),
    @NamedQuery(name = "Product.findByStock", query = "SELECT p FROM Product p WHERE p.stock = :stock"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByDateOfNextReposition", query = "SELECT p FROM Product p WHERE p.dateOfNextReposition = :dateOfNextReposition"),
    @NamedQuery(name = "Product.findStockByProduct", query = "SELECT p.stock FROM Product p WHERE P = :product"),
    @NamedQuery(name = "Product.findDateOfNextRepositionByProduct", query = "SELECT p.dateOfNextReposition FROM Product p WHERE P = :product")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private Integer productId;
    @Size(max = 255)
    @Column(name = "brand")
    private String brand;
    @Size(max = 255)
    @Column(name = "category")
    private String category;
    @Column(name = "date_of_next_reposition")
    @Temporal(TemporalType.DATE)
    private Date dateOfNextReposition;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "model")
    private String model;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private Double price;
    @Size(max = 255)
    @Column(name = "product_name")
    private String productName;
    @Column(name = "stock")
    private Integer stock;
    @Size(max = 255)
    @Column(name = "version")
    private String version;
    @JoinColumn(name = "Category_category_id", referencedColumnName = "category_id")
    @ManyToOne
    private Category categorycategoryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<ProductHasAttribute> productHasAttributeCollection;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDateOfNextReposition() {
        return dateOfNextReposition;
    }

    public void setDateOfNextReposition(Date dateOfNextReposition) {
        this.dateOfNextReposition = dateOfNextReposition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Category getCategorycategoryid() {
        return categorycategoryid;
    }

    public void setCategorycategoryid(Category categorycategoryid) {
        this.categorycategoryid = categorycategoryid;
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
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.uc.dei.aor.projeto7.grupoc.rest.products.Product[ productId=" + productId + " ]";
    }
    
}
