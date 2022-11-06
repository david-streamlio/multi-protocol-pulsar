package io.streamnative.protocols.amqp.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class AmqpMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private int msgCounter = 0;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        rabbitTemplate.convertAndSend(Constants.TOPIC_NAME,
                String.format("%s - %d", Constants.THE_RABBIT_SAYS, ++msgCounter));
    }

}
