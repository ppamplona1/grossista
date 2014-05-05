/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.uc.dei.aor.projeto7.grupoc.entities;

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
 * @author User
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findByOrderId", query = "SELECT o FROM Order1 o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "Order1.findByOrderName", query = "SELECT o FROM Order1 o WHERE o.orderName = :orderName"),
    @NamedQuery(name = "Order1.findByExpectedDate", query = "SELECT o FROM Order1 o WHERE o.expectedDate = :expectedDate")})
public class Order1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private Integer orderId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "order_name")
    private String orderName;
    @Column(name = "expectedDate")
    @Temporal(TemporalType.DATE)
    private Date expectedDate;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "order1")
    private Collection<OrderHasProduct> orderHasProductCollection;
    @JoinColumn(name = "Client_client_id", referencedColumnName = "client_id")
    @ManyToOne(optional = false)
    private Client clientclientid;

    public Order1() {
    }

    public Order1(Integer orderId) {
        this.orderId = orderId;
    }

    public Order1(Integer orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    @XmlTransient
    public Collection<OrderHasProduct> getOrderHasProductCollection() {
        return orderHasProductCollection;
    }

    public void setOrderHasProductCollection(Collection<OrderHasProduct> orderHasProductCollection) {
        this.orderHasProductCollection = orderHasProductCollection;
    }

    public Client getClientclientid() {
        return clientclientid;
    }

    public void setClientclientid(Client clientclientid) {
        this.clientclientid = clientclientid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.uc.dei.aor.projeto7.grupoc.entities.Order1[ orderId=" + orderId + " ]";
    }

}
