package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Service {
    private static final Logger log = LoggerFactory.getLogger(Service.class.getName());
    private final AtomicInteger counter = new AtomicInteger(0);

    public void incrementCounter() {
        log.info("Running... counter: {}", counter.get());

        counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
