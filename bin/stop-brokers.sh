#!/bin/bash

INFRA_DIR="../shared-infrastructure"

docker compose --project-name brokers --file $INFRA_DIR/brokers.yml down
