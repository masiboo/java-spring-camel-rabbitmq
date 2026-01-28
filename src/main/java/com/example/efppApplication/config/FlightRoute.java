package com.example.efppApplication.config;

import com.example.efppApplication.model.FlightPlan;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class FlightRoute extends RouteBuilder {

    @Override
    public void configure() {

        errorHandler(deadLetterChannel("rabbitmq:flight.errors")
                .maximumRedeliveries(3).redeliveryDelay(1000));

        from("rabbitmq:flight.process?queue=flight.process.queue&autoDelete=false")
                .unmarshal().json(JsonLibrary.Jackson, FlightPlan.class)
                .choice()
                .when(simple("${body.aircraftType} == 'A380'"))
                .to("rabbitmq:flight.priority?queue=flight.priority.queue")
                .otherwise()
                .to("direct:processFlight");

        from("direct:processFlight")
                .to("bean:flightValidator")
                .to("bean:flightEnricher")
                .to("bean:flightSaver");
    }
}
