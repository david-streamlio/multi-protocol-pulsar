package io.streamnative.protocols.mqtt.demo;

import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.Message;
import org.fusesource.mqtt.client.QoS;
import org.fusesource.mqtt.client.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

import static io.streamnative.protocols.mqtt.demo.Constants.TOPIC_NAME;

@EnableScheduling
@SpringBootApplication
public class MqttApp implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(MqttApp.class);

    public static void main(String[] args) {
        SpringApplication.run(MqttApp.class, args);
    }

    @Autowired
    private BlockingConnection connection;

    @Autowired
    @Qualifier("threadPoolTaskExecutor")
    private TaskExecutor taskExecutor;

    private int msgCounter = 0;

    @Scheduled(initialDelay = 1000, fixedRate = 2000)
    public void repeatRun() {
        sendData();
    }

    private void sendData() {
        try {
            connection.publish(TOPIC_NAME,
                    String.format("%s - %d", Constants.THE_MOUSE_SAYS, ++msgCounter).getBytes(),
                    QoS.AT_LEAST_ONCE, false);
        } catch (Exception e) {
            logger.error("Failure to send", e);
        }
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Starting the MQTT consumer");
        taskExecutor.execute(new MqttMessageConsumer(connection));
    }

}
