package io.streamnative.protocols.kafka.demo;

public interface Constants {
    public static final String TOPIC_NAME = "multi-protocol";

    static final String DOG_FACE = "🐶";

    public static final String THE_DOG_SAYS = String.format("%s - I am using Kafka to talk to Pulsar", DOG_FACE);
}
