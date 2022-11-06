package io.streamnative.protocols.mqtt.demo;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.fusesource.mqtt.client.BlockingConnection;
import org.fusesource.mqtt.client.MQTT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.net.URISyntaxException;

@Configuration
@EnableAsync
public class MqttConfig {

    @Bean
    public MQTT mqtt(@Value("${mqtt.producer.hostname}") String hostname) throws URISyntaxException {
        MQTT mqtt = new MQTT();
        mqtt.setHost(hostname, 1883);
        return mqtt;
    }

    @Bean
    public BlockingConnection connection(@Value("${mqtt.producer.hostname}") String hostname) throws Exception {
        BlockingConnection connection = mqtt(hostname).blockingConnection();
        connection.connect();
        return connection;
    }

    @Bean(name = "threadPoolTaskExecutor")
    public TaskExecutor getTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(1);
        threadPoolTaskExecutor.setMaxPoolSize(5);
        return threadPoolTaskExecutor;
    }

}
