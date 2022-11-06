#!/bin/bash

set -e
msWithAmqpFolder="microservice-with-amqp"
workingDir=$PWD

if [[ $workingDir != *$msWithAmqpFolder ]]
then
  cd $msWithAmqpFolder
fi

# mvn clean package -Dmaven.test.skip=true

# docker run -it --rm --name amqp -v "$PWD":/usr/src/app \
#       -v "$HOME"/.m2:/root/.m2 \
#       -w /usr/src/app maven:3.8-openjdk-17 mvn clean package

docker build . -t aop/microservice:1.0

docker run --name aop-micro \
       -e AMQP_SERVERS='broker-1:5672' \
       -e AMQP_VHOST='vhost1' \
       -e AMQP_HOST='broker-1' \
       --network="multi-protocol-pulsar" \
       -t aop/microservice:1.0
