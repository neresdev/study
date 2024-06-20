package com.nrs.springexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrs.springexample.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
