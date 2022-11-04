package io.streamnative.protocols.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static io.streamnative.protocols.kafka.demo.Constants.*;

@Service
public class KafkaMessageProducer {

    private final Logger logger = LoggerFactory.getLogger(KafkaMessageProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 5000)
    public void forgetAndMoveOn() {

        final String message = "I am using Kafka to talk to Pulsar 😄";
        kafkaTemplate.send(TOPIC_NAME, message);

    }

    @KafkaListener(topics = Constants.TOPIC_NAME)
    public void sayHi(@Payload String message) {
        logger.info(message);
    }

}
