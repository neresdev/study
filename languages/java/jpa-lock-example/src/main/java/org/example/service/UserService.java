package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.example.entities.UserEntity;
import org.example.exceptions.UserNotFoundException;
import org.example.repositories.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class UserService {
    private static final Logger log = Logger.getLogger(UserService.class.getName());
    private static final String DEFAULT_NAME = "John Doe";
    private static final String DEFAULT_NAME_UPDATED = "John Doe Updated";

    private final UserRepository repository;
    private final Faker faker;
    private final ObjectMapper objectMapper;

    public UserService(UserRepository repository, Faker faker, ObjectMapper objectMapper) {
        this.repository = repository;
        this.faker = faker;
        this.objectMapper = objectMapper;
    }

    public void process() throws InterruptedException {
        final var executor = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 1; i++) {
            executor.submit(this::updateUser);
            executor.submit(this::findTest);
        }

        final var haveError = executor.awaitTermination(1000, TimeUnit.MILLISECONDS);

        if (haveError) {
            log.warning("Warning! Has an error while processing.");
        }
    }

    @Transactional
    private void findTest() {
        log.info("Finding user by name %s".formatted(DEFAULT_NAME));

        try {
            final var user = repository.findByName(DEFAULT_NAME);
            if (user.isEmpty()) {
                log.info("User not fund!");
                return;
            }
            log.info("User found!");
            log.info("findTest: " + objectMapper.writeValueAsString(user));
            Thread.sleep(10000L);
        } catch (Exception e) {
            e.printStackTrace();
            log.throwing(this.getClass().getName(), "findTest", e);
        }
    }

    @Transactional
    private void updateUser() {
        try {
            log.info("Updating user.");
            final var user = repository.findByName(DEFAULT_NAME).orElseThrow(() -> new UserNotFoundException("User with name %s not found".formatted(DEFAULT_NAME)));
            user.setName(DEFAULT_NAME_UPDATED);
            repository.save(user);
            Thread.sleep(5000L);
            log.info("User updated");
            log.info("updateUser: " + objectMapper.writeValueAsString(user));
        } catch (Exception e) {
            e.printStackTrace();
            log.throwing(this.getClass().getName(), "findTest", e);
        }

    }


    public List<UserEntity> getUsers() {

        return repository.findAll();
    }



}
