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

    public User insert(User user){
       return repository.save(user);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public User update(Long id, User user){
        User monitoredUser = repository.getReferenceById(id);
        updateData(monitoredUser, user);
        return repository.save(monitoredUser);
    }

    private void updateData(User monitoredUser, User user) {
        monitoredUser.setName(user.getName());
        monitoredUser.setEmail(user.getEmail());
        monitoredUser.setPhone(user.getPhone());
    }
}
