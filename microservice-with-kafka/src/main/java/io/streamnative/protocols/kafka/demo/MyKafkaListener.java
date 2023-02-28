package io.streamnative.protocols.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {

    private final Logger logger = LoggerFactory.getLogger(MyKafkaListener.class);

    @KafkaListener(topics = Constants.TOPIC_NAME, properties = {"auto.offset.reset = latest"})
    public void sayHi(@Payload String message) {
        logger.info(String.format("Received [%s]", message));
    }
}
