package com.nrs.springexample.services;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.nrs.springexample.entities.User;
import com.nrs.springexample.repositories.UserRepository;
import com.nrs.springexample.services.exceptions.DatabaseException;
import com.nrs.springexample.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
    
    private final UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
       return repository.save(user);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User user){
        try{
            User monitoredUser = repository.getReferenceById(id);
            updateData(monitoredUser, user);
            return repository.save(monitoredUser);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
        
    }

    private void updateData(User monitoredUser, User user) {
        monitoredUser.setName(user.getName());
        monitoredUser.setEmail(user.getEmail());
        monitoredUser.setPhone(user.getPhone());
    }
}
