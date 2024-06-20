package com.nrs.springexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrs.springexample.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}
