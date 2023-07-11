#!/bin/bash

msWithJMSFolder="microservice-with-jms"
workingDir=$PWD

if [[ $workingDir != *$msWithJMSFolder ]]
then
  cd $msWithJMSFolder
fi

mvn clean package -Dmaven.test.skip=true

docker build . -t jms/microservice:1.0

docker run --rm --name jms-micro  \
       --network="multi-protocol-pulsar" \
       -t jms/microservice:1.0
