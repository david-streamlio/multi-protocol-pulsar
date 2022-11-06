package io.streamnative.protocols.kafka.demo;

public interface Constants {
    public static final String TOPIC_NAME = "persistent://public/vhost1/__amqp_exchange__aop.direct.durable";

    static final String DOG = "🐶";

    public static final String THE_DOG_SAYS = String.format("%s - I am using Kafka to talk to Pulsar", DOG);
}