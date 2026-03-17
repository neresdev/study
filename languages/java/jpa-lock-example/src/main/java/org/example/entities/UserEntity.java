package org.example.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
public class UserEntity implements Serializable {
    @Id
    @Column(name = "IDT_USER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private int age;

    @Column(name = "CHANGE_AGENT")
    private String changeAgent;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    public UserEntity() {
    }

    public UserEntity(String name, int age, String changeAgent, LocalDateTime createdAt) {
        this.name = name;
        this.age = age;
        this.changeAgent = changeAgent;
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getChangeAgent() {
        return changeAgent;
    }

    public void setChangeAgent(String changeAgent) {
        this.changeAgent = changeAgent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
