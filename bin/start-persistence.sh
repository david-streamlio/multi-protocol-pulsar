#!/bin/bash

INFRA_DIR="../shared-infrastructure"

docker compose --project-name persistence --file $INFRA_DIR/persistence.yml up -d
