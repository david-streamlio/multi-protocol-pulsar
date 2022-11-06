package io.streamnative.protocols.mqtt.demo;

public interface Constants {

    public static final String TOPIC_NAME = "persistent://public/vhost1/__amqp_exchange__aop.direct.durable";

    static final String CAT = "🐱";

    public static final String THE_CAT_SAYS = String.format("%s - I am using MQTT to talk to Pulsar",CAT);
    
}
