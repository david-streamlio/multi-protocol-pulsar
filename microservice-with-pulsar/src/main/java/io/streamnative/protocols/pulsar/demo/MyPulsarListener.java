package io.streamnative.protocols.pulsar.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.stereotype.Service;

import static io.streamnative.protocols.pulsar.demo.Constants.TOPIC_NAME;

@Service
public class MyPulsarListener {

    private final Logger logger = LoggerFactory.getLogger(MyPulsarListener.class);

    @PulsarListener(subscriptionName = "hello-pulsar-subscription", topics = TOPIC_NAME)
    void listen(byte[] message, @Header("priority") String priority) {
        logger.info(String.format("Received [%s] with priority [%s]", new String(message), priority));
    }
}
