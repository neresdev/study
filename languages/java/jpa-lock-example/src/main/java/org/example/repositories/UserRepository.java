package org.example.repositories;

import org.example.entities.UserEntity;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.time.LocalDateTime;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Modifying
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Query(value = "INSERT INTO USERS (NAME, AGE, CHANGE_AGENT, CREATED_AT) VALUES (:name, :age, :changeAgent, :createdAt)", nativeQuery = true)
    void saveUserNative(
            @Param("name") String name,
            @Param("age") int age,
            @Param("changeAgent") String changeAgent,
            @Param("createdAt") LocalDateTime createdAt
    );

    @Transactional(propagation = Propagation.REQUIRED)
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<UserEntity> findByName(String name);
}
