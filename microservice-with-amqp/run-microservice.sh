#!/bin/bash

set -e
msWithAmqpFolder="microservice-with-amqp"
workingDir=$PWD

if [[ $workingDir != *$msWithAmqpFolder ]]
then
  cd $msWithAmqpFolder
fi

mvn clean package -Dmaven.test.skip=true

docker build . -t aop/microservice:1.0

docker run --rm --name aop-micro \
       -e AMQP_SERVERS='broker-1:5672' \
       -e AMQP_VHOST='vhost1' \
       -e AMQP_HOST='broker-1' \
       --network="multi-protocol-pulsar" \
       -t aop/microservice:1.0
