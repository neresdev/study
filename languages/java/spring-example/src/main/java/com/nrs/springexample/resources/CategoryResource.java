package com.nrs.springexample.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nrs.springexample.entities.Category;
import com.nrs.springexample.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryResource {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = service.findAll();
        return ResponseEntity.ok().body(categories);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }
    
}
