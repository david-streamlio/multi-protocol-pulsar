package io.streamnative.protocols.mqtt.demo;

import org.fusesource.mqtt.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class MqttMessageConsumer implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(MqttMessageConsumer.class);

    private final BlockingConnection connection;

    private boolean subscribed = false;

    public MqttMessageConsumer(BlockingConnection connection) {
        this.connection = connection;
    }


    public void run() {
        try {
            Topic[] topics = {new Topic(Constants.TOPIC_NAME, QoS.AT_LEAST_ONCE)};
            connection.subscribe(topics);
            logger.info("Subscribed to " + Constants.TOPIC_NAME);

            while (true) {
                Message received = connection.receive(10, TimeUnit.SECONDS);
                if (received != null) {
                    logger.info(String.format("Received [%s]", new String(received.getPayload())));
                    received.ack();
                } else {
                    logger.info("Receive timed out");
                }
            }
        } catch (Throwable t) {
            logger.error("Failed to consume messages", t);
        }
    }

}
