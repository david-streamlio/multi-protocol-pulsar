package io.streamnative.protocols.jms.demo;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyJmsProducer {

    private final JmsTemplate jmsTemplate;

    private int msgCounter = 0;

    public MyJmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        jmsTemplate.convertAndSend(Constants.QUEUE_NAME,
                String.format("%s - %d", Constants.THE_FOX_SAYS, ++msgCounter));

    }
}
