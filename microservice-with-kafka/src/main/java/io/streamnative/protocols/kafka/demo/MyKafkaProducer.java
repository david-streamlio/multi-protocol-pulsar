package io.streamnative.protocols.kafka.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static io.streamnative.protocols.kafka.demo.Constants.*;

@Service
public class MyKafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(MyKafkaProducer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private int msgCounter = 0;

    @Scheduled(fixedRate = 5000)
    public void forgetAndMoveOn() {
        kafkaTemplate.send(TOPIC_NAME, String.format("%s - %d", THE_DOG_SAYS, ++msgCounter));
    }

}
