package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int slots = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(slots);
        LoginServiceUsingSemaphore loginQueue = new LoginServiceUsingSemaphore();
        IntStream.range(0, slots)
                .forEach(user -> executorService.execute(loginQueue::makeLogin));
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);

        loginQueue.logout();

    }
}