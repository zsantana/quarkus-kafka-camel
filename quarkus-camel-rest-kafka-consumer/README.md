# Consumidor Kafka com Apache Camel

Microsserviço de integração com API Rest e recebimento de mensagem do tópico kafka utlizando o framework Apache Camel.


## 💻 Getting started

```bash
# Build 
$ mvn clean package

# Local execution
$ mvn quarkus:dev -Ddebug=false
```


## Getting started Docker
```bash
# Install image from file build_docker_push.sh 
$ ./build_docker_push.sh 

# Started and attaches to containers for a service
$ docker-compose --env-file ./.env up
```


## Getting started Docker (Native Image)
```bash
# Install image from file build_docker_push.sh 
$ ./build_docker_native.sh 

# Started and attaches to containers for a service
$ docker-compose -f docker-compose-native.yml --env-file ./.env up
```


## ✔️ Required
* Maven: 3.8.4
* Java version: 17
* Docker version: 20.10.17
* Docker-compose version: v2.2.2


Docker Image:
* obsidiandynamics/kafdrop
* confluentinc/cp-zookeeper:latest
* confluentinc/cp-kafka:latest


## Integrated tools:

Observability:

* smallrye-openapi
* smallrye-metrics
* smallrye-health 
* opentelemetry


Other integrations:
* resteasy-reactive-jackson
* lombok


# Autor
Reinaldo Jesus Santana - reinaldojsantana@gmail.com
