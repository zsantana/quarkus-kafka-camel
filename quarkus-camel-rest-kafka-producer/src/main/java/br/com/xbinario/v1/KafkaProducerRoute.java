package br.com.xbinario.v1;

import org.apache.camel.builder.RouteBuilder;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaProducerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:kafkaProducer")
            .log("Enviando mensagem para o tópico : \"${body}\" ")
            .to("kafka:{{kafka.topic.name}}");

    }
}
