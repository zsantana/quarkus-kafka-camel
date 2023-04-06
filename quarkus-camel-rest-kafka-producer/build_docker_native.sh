#!/bin/bash

mvn clean package -Pnative -Dquarkus.native.container-build=true
docker build -f Dockerfile.native --no-cache -t native-quarkus-camel-rest-kafka-producer:v1.0.0 .

#docker push 442494/native-quarkus-camel-rest-kafka:v1.0.0
#docker-compose -f docker-compose-native.yml --env-file ./.env up