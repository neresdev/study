package com.nrs.springexample.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nrs.springexample.entities.User;
import com.nrs.springexample.services.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        var userInserted = service.insert(user);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userInserted.getId())
            .toUri();
        return ResponseEntity.created(uri).body(userInserted);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updaEntity(@PathVariable Long id, @RequestBody User user) {
        user = service.update(id, user);
        return ResponseEntity.ok().body(user);
    }
    
}
