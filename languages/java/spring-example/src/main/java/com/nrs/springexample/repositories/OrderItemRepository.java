package com.nrs.springexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrs.springexample.entities.OrderItem;
import com.nrs.springexample.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
    
}
