package io.streamnative.protocols.pulsar.demo;

import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

import static io.streamnative.protocols.pulsar.demo.Constants.*;

@Service
public class MyPulsarProducer {

    @Autowired
    PulsarTemplate<byte[]> pulsarTemplate;

    private Random rnd = new Random();

    private int msgCounter = 0;

    @Scheduled(fixedRate = 2000)
    public void triggerSend() throws PulsarClientException {
        this.sendMessage(rnd.nextBoolean());
    }

    public void sendMessage(boolean highPriority) throws PulsarClientException {
        pulsarTemplate.newMessage(String.format("%s - %d", THE_UNICORN_SAYS, ++msgCounter).getBytes())
                .withTopic(TOPIC_NAME)
                .withMessageCustomizer((mb) -> mb.property("priority", highPriority ? "high" : "low"))
                .send();
    }
}

