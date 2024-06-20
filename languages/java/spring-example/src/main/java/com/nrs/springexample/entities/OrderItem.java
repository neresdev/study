package com.nrs.springexample.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nrs.springexample.entities.pk.OrderItemPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK(); // chave composta

    @Getter
    @Setter
    private Integer quantity;

    @Getter
    @Setter
    private Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    
    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }
    
    public void setOrder(Order order){
        id.setOrder(order);
    }
    
    public Product getProduct(){
        return id.getProduct();
    }
    
    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Double getSubTotal(){
        return price * quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
