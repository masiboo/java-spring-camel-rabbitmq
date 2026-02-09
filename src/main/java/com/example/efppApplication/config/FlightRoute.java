package com.example.efppApplication.config;

import com.example.efppApplication.model.FlightPlan;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlightRoute extends RouteBuilder {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void configure() {
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(FlightPlan.class);
        jacksonDataFormat.setObjectMapper(objectMapper);

        from("spring-rabbitmq:flight.process?queues=flight.process.queue&autoDeclare=true")
                .log("Received message from RabbitMQ: ${body}")
                .unmarshal(jacksonDataFormat)
                .log("Unmarshalled body: ${body}")
                .choice()
                .when(simple("${body.aircraftType} == 'A380'"))
                .log("Priority flight detected: ${body.flightId}")
                .marshal(jacksonDataFormat)
                .to("spring-rabbitmq:flight.priority?queues=flight.priority.queue&autoDeclare=true")
                .otherwise()
                .to("direct:processFlight")
                .end();

        from("direct:processFlight")
                .log("Processing flight in direct:processFlight: ${body}")
                .to("bean:flightValidator?method=validate")
                .log("Validated flight: ${body}")
                .to("bean:flightEnricher?method=enrich")
                .log("Enriched flight: ${body}")
                .to("bean:flightSaver?method=save")
                .log("Saved flight: ${body}");
    }
}