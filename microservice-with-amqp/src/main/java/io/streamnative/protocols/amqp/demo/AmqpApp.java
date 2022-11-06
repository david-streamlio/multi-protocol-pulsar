package io.streamnative.protocols.amqp.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableRabbit
@SpringBootApplication
public class AmqpApp {

    public static void main(String[] args) {
        SpringApplication.run(AmqpApp.class, args);
    }
    
}
