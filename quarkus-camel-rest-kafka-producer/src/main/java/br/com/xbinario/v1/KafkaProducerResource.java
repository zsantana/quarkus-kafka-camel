package br.com.xbinario.v1;

import org.apache.camel.ProducerTemplate;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/kafka")
public class KafkaProducerResource {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerResource.class);

    @Inject
    ProducerTemplate producerTemplate;

    @POST
    @Path("/producer")
    //@RolesAllowed("REGISTRA_TOPICO_KAFKA")
    @Consumes(MediaType.APPLICATION_JSON)
    @Tag(name = "Kafka com Apache Camel",  
         description = "Endpoint para recebimento de mensagens para registrar em um tópico Kafka")
    @APIResponses({
        @APIResponse(responseCode = "200", description = "Mensagem enviada com sucesso."),
        @APIResponse(responseCode = "422", description = "Erro na conversão do JSON"),
    })

    @Counted(name = "Counted.sendMessage", tags = {"servico=sendMessage"},
            description = "Total de Chamadas do enpoint"
            )

    @Timed(name = "Timed.sendMessage", 
            tags = {"servico=sendMessage"},
            description = "Tempo medio das requisicoes.", 
            unit = MetricUnits.MILLISECONDS)

    @Retry(maxRetries = 3, delay = 2000)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 5000, successThreshold = 2)
    public Response sendMessage(@Valid RequestDTO message) {

        logger.info("Recebendo mensagem {}: ", message);
        producerTemplate.sendBody("direct:kafkaProducer", message);
        
        return Response.ok().build();
    }

    
}