package io.streamnative.protocols.pulsar.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class PulsarApp {

    public static void main(String[] args) {
        SpringApplication.run(PulsarApp.class, args);
    }

//    @Bean
//    ApplicationRunner runner(PulsarTemplate<String> pulsarTemplate) {
//        return (args) -> pulsarTemplate.send(TOPIC_NAME, "Hello Pulsar World!");
//    }

//    @PulsarListener(subscriptionName = "hello-pulsar-subscription", topics = TOPIC_NAME)
//    void listen(String message) {
//        System.out.println("Message Received: " + message);
//    }
}
