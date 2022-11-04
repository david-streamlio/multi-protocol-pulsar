#!/bin/bash

INFRA_DIR="../shared-infrastructure"

docker compose --project-name control-plane --file $INFRA_DIR/control-plane.yml down