package br.com.xbinario.v1;

import org.apache.camel.builder.RouteBuilder;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("kafka:{{kafka.topic.name}}?autoOffsetReset=latest&groupId=my-group-id")
        .log("Message received from Kafka : ${body}")
        //.to("http://localhost:8081/credit-card/api/v1/transaction")
        ;

    }
}
