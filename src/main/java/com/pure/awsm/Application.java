package com.pure.awsm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> shutdownHook()));
    }

    private static void shutdownHook() {
        log.info("Inside Shutdown Hook..");
        log.info("Shutdown Cleanup Done");
    }
}
