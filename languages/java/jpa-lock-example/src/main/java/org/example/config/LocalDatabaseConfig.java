package org.example.config;

import com.github.javafaker.Faker;
import org.example.entities.UserEntity;
import org.example.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Configuration
public class LocalDatabaseConfig {
    private static final String DEFAULT_NAME = "John Doe";
    private final UserRepository repository;
    private final Faker faker;

    public LocalDatabaseConfig(UserRepository repository, Faker faker) {
        this.repository = repository;
        this.faker = faker;
    }


    @Bean
    public void startDB() {
            final var userBuilt = buildRandomUser(true);
            repository.saveUserNative(userBuilt.getName(), userBuilt.getAge(), userBuilt.getChangeAgent(), userBuilt.getCreatedAt());
    }

    private synchronized void insert() {


    }

    public UserEntity buildRandomUser(final boolean isDefault) {
        final var name = isDefault ? DEFAULT_NAME : faker.name().firstName();
        final var age = new Random().nextInt(100) + 1;
        return new UserEntity(name, age, Thread.currentThread().getName(), LocalDateTime.now());
    }
}
