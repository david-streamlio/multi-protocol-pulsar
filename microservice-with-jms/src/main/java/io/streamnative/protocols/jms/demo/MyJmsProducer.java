package io.streamnative.protocols.jms.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class MyJmsProducer {

    private final Logger logger = LoggerFactory.getLogger(MyJmsProducer.class);

    private final JmsTemplate jmsTemplate;

    private int msgCounter = 0;

    private Random rnd = new Random();

    public MyJmsProducer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Scheduled(fixedRate = 2000)
    public void triggerSend() {
        send(Constants.QUEUE_NAME,
                String.format("%s - %d", Constants.THE_FOX_SAYS, ++msgCounter),
                rnd.nextBoolean());
    }

    public void send(String destination, String message, boolean isHighPriority) {
 //       logger.info("sending message='{}' with highPriority='{}'",
 //               message, isHighPriority);

        if (isHighPriority) {
            jmsTemplate.convertAndSend(destination, message.getBytes(),
                    messagePostProcessor -> {
                        messagePostProcessor.setStringProperty("priority",
                                "high");
                        return messagePostProcessor;
                    });
        } else {
            jmsTemplate.convertAndSend(destination, message.getBytes(),
                    messagePostProcessor -> {
                        messagePostProcessor.setStringProperty("priority",
                                "low");
                        return messagePostProcessor;
                    });
        }
    }
}
