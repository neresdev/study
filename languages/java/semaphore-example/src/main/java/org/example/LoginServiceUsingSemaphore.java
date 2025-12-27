package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.Semaphore;


public class LoginServiceUsingSemaphore {
    private Logger logger = LogManager.getLogger(this.getClass().getName());
    private final Semaphore semaphore;

    public LoginServiceUsingSemaphore() {
        this.semaphore = new Semaphore(1);
    }


    public boolean tryLogin() {
        if(semaphore.tryAcquire()) {
            logger.info("a thread {} conseguiu fazer o login", Thread.currentThread().getName());
            return true;
        }

        logger.error("a thread {} NÃO conseguiu fazer o login", Thread.currentThread().getName());
        return false;
    }

    public void makeLogin() {
        try {
            logger.info("Trying to make login...");
            Thread.sleep(3000L);
            semaphore.acquire();
            logger.info("Login done!");
            Thread.sleep(3000L);
            semaphore.release();
        }catch (Exception ignore) {

        }

    }

    public void logout() {
        semaphore.release();
    }

    public int availableSlots() {
        return semaphore.availablePermits();
    }

}
