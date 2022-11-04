package io.streamnative.protocols.amqp.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static io.streamnative.protocols.amqp.demo.Constants.*;

@Service
public class AmqpMessageProducer {

    private final Logger logger = LoggerFactory.getLogger(AmqpMessageProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() {
        final String message = "I am using AMQP to talk to Pulsar 😄";
        rabbitTemplate.convertAndSend(TOPIC_NAME, message);
    }

    @RabbitListener(queues = TOPIC_NAME)
    public void listen(String message) {
        logger.info(message);
    }

}
