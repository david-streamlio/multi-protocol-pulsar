package io.streamnative.protocols.pulsar.demo;

import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static io.streamnative.protocols.pulsar.demo.Constants.*;

@Service
public class MyPulsarProducer {

    @Autowired
    PulsarTemplate<byte[]> pulsarTemplate;

    private int msgCounter = 0;

    @Scheduled(fixedRate = 5000)
    public void sendMessage() throws PulsarClientException {
        pulsarTemplate.send(TOPIC_NAME, String.format("%s - %d", THE_UNICORN_SAYS, ++msgCounter).getBytes());
    }
}

