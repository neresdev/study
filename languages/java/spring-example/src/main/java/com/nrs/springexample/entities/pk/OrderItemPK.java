package com.nrs.springexample.entities.pk;

import java.io.Serializable;

import com.nrs.springexample.entities.Order;
import com.nrs.springexample.entities.Product;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Embeddable
public class OrderItemPK implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;



}
