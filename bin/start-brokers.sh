#!/bin/bash

INFRA_DIR="../shared-infrastructure"

docker compose --project-name brokers --file $INFRA_DIR/brokers.yml up -d

################################################
# Wait 15 seconds for Pulsar to start
################################################
sleep 15

################################################
# Create namespace and set policies
################################################
# docker exec -it broker-1 /pulsar/bin/pulsar-admin namespaces create -b 1 public/vhost1
# docker exec -it broker-1 /pulsar/bin/pulsar-admin namespaces set-retention -s 100M -t 2d  public/vhost1