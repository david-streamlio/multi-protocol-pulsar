package io.streamnative.protocols.jms.demo;

import com.datastax.oss.pulsar.jms.PulsarConnectionFactory;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJms
public class JmsConfig {

    @Bean
    public ConnectionFactory connectionFactory() {
        Map<String, Object> properties = new HashMap<>();
        properties.put("brokerServiceUrl", "pulsar://broker-1:6650");
        properties.put("webServiceUrl", "http://broker-1:8080");
        return new PulsarConnectionFactory(properties);
    }

    @Bean
    public JmsListenerContainerFactory<?> myJmsContainerFactory(
            ConnectionFactory connectionFactory,
            DefaultJmsListenerContainerFactoryConfigurer configurer) {

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        configurer.configure(factory, connectionFactory);
        factory.setSessionTransacted(false);

        return factory;
    }

}
