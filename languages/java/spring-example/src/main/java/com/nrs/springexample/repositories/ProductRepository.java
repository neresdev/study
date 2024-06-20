package com.nrs.springexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrs.springexample.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
