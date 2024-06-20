package com.nrs.springexample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nrs.springexample.entities.Category;
import com.nrs.springexample.repositories.CategoryRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
    
    private final CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        return repository.findById(id).orElse(null);
    }
}
