#!/bin/bash

msWithPulsarFolder="microservice-with-pulsar"
workingDir=$PWD

if [[ $workingDir != *$msWithPulsarFolder ]]
then
  cd $msWithPulsarFolder
fi

mvn clean package -Dmaven.test.skip=true

docker build . -t pop/microservice:1.0

docker run --rm --name pop-micro  \
       --network="multi-protocol-pulsar" \
       -t pop/microservice:1.0
