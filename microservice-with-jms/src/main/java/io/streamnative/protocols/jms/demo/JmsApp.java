package io.streamnative.protocols.jms.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJms
@SpringBootApplication
public class JmsApp {

    public static void main(String[] args) {
        SpringApplication.run(JmsApp.class, args);
    }
}
