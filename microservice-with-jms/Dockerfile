FROM maven:3.8.1-openjdk-17-slim

VOLUME /tmp
ADD . /usr/src/app
WORKDIR /usr/src/app

RUN --mount=type=cache,target=/root/.m2 mvn clean package -DskipTests
ENTRYPOINT [ "java", "-jar", "target/jms-microservice-1.0.jar" ]
