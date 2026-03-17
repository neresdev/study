package org.example.resources;


import org.example.entities.UserEntity;
import org.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("process")
    public String process() throws InterruptedException {
        userService.process();
        return "ok";
    }

    @GetMapping("get-users")
    public List<UserEntity> getUsers() {
        return userService.getUsers();
    }

}
