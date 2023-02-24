#!/bin/bash

msWithKafkaFolder="microservice-with-kafka"
workingDir=$PWD

if [[ $workingDir != *$msWithKafkaFolder ]]
then
  cd $msWithKafkaFolder
fi

mvn clean package -Dmaven.test.skip=true

docker build . -t kop/microservice:1.0

docker run --rm --name kop-micro -e BOOTSTRAP_SERVERS='broker-1:9092' \
       --network="multi-protocol-pulsar" \
       -t kop/microservice:1.0
