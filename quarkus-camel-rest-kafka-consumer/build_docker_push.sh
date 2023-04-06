#!/bin/bash

mvn clean package -DskipTests=true

docker build --no-cache -t quarkus-camel-rest-kafka-consumer:v1.0.0 .

#docker push 442494/quarkus-camel-rest-kafka-consumer:v1.0.0
#kubectl apply -f minikube-deployment-all.yaml

docker-compose --env-file ./.env up