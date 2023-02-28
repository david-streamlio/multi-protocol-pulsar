#!/bin/bash

msWithMqttFolder="microservice-with-mqtt"
workingDir=$PWD

if [[ $workingDir != *$msWithMqttFolder ]]
then
  cd $msWithMqttFolder
fi

mvn clean package -Dmaven.test.skip=true

docker build . -t mop/microservice:1.0

docker run --rm --name mop-micro  \
       --network="multi-protocol-pulsar" \
       -t mop/microservice:1.0
