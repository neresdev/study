package com.nrs.springexample.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrs.springexample.entities.Product;
import com.nrs.springexample.services.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResource {

    private final ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    
}
