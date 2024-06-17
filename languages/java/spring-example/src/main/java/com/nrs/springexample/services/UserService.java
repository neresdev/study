package com.nrs.springexample.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nrs.springexample.entities.User;
import com.nrs.springexample.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).orElse(null);
    }
}
