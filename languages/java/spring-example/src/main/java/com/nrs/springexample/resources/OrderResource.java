package com.nrs.springexample.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrs.springexample.entities.Order;
import com.nrs.springexample.services.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderResource {

    private final OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> Orders = service.findAll();
        return ResponseEntity.ok().body(Orders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    
}
