package io.streamnative.protocols.amqp.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MyAmqpListener {

    private final Logger logger = LoggerFactory.getLogger(MyAmqpListener.class);

    @RabbitListener(queues = Constants.TOPIC_NAME)
    public void listen(@Payload String message) {
        logger.info(String.format("Received [%s]", message));
    }

}
