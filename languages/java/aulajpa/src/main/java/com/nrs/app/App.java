package com.nrs.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.nrs.domain.People;


public class App {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        People p = entityManager.find(People.class, 2);
        entityManager.remove(p);
        entityManager.getTransaction().commit();
        System.out.println("Pronto!");
        entityManager.close();
        entityManagerFactory.close();
    }
}
