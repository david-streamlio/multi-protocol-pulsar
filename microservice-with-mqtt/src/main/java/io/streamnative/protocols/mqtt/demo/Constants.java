package io.streamnative.protocols.mqtt.demo;

public interface Constants {

    public static final String TOPIC_NAME = "persistent://public/default/helloPulsarTopic";

    static final String MOUSE = "🐭";

    public static final String THE_MOUSE_SAYS = String.format("%s - I am using MQTT to talk to Pulsar",MOUSE);
    
}
