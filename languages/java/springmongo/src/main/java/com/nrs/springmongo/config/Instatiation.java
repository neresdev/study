package com.nrs.springmongo.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import com.nrs.springmongo.domain.User;
import com.nrs.springmongo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@DependsOn("documentDbConfig")
@RequiredArgsConstructor
public class Instatiation implements CommandLineRunner{

    private final UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        
        userRepository.deleteAll();

        User user1 = new User(null, "Maria Brown", "maria@hotmail.com"); 
        User user2 = new User(null, "Alex Green", "alex@gmail.com"); 
        User user3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(user1, user2, user3));
    }
    
}
