package com.nrs.springexample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nrs.springexample.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
