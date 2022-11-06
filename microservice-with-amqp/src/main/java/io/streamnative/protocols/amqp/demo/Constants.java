package io.streamnative.protocols.amqp.demo;

public interface Constants {

    public static final String TOPIC_NAME = "myqueue";

    static final String RABBIT = "🐰";

    public static final String THE_RABBIT_SAYS = String.format("%s - I am using AMQP to talk to Pulsar", Constants.RABBIT);
}
