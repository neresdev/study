package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Service service = new Service();
        System.out.printf("Counter antes de tudo %s%n", service.getCounter());

        final var executorService = Executors.newFixedThreadPool(4);
        for(int i = 0; i < 50000; i++) {
            executorService.execute(service::incrementCounter);
        }
        executorService.shutdown();
        final var isExecutorTerminated = executorService.awaitTermination(5000L, TimeUnit.MILLISECONDS);

        if (!isExecutorTerminated) {
            System.out.println("Executor timeout!");
            return;
        }

        System.out.printf("Counter depois de tudo %s%n", service.getCounter());

    }
}