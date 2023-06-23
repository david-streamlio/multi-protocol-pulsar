package io.streamnative.protocols.jms.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MyJmsListener {

    private final Logger logger = LoggerFactory.getLogger(MyJmsListener.class);

    @JmsListener(destination = Constants.QUEUE_NAME, containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
        logger.info(String.format("Received [%s]", message));
    }
}
