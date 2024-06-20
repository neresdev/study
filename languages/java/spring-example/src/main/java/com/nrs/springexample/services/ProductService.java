package com.nrs.springexample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nrs.springexample.entities.Product;
import com.nrs.springexample.repositories.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
    
    private final ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        return repository.findById(id).orElse(null);
    }
}
