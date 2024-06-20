package com.nrs.springexample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nrs.springexample.entities.Order;
import com.nrs.springexample.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    
    private final OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        return repository.findById(id).orElse(null);
    }
}
