package com.routing.apachecamel.apachecamelintegration.routers;

import com.routing.apachecamel.apachecamelintegration.sender.ApacheCamelSender;
import org.apache.camel.ExchangePattern;
import org.apache.camel.Processor;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApacheCamelRouters extends RouteBuilder {

    @Autowired
    ApacheCamelSender sender;


    @Override
    public void configure() throws Exception {

        from("direct:start")
                .log("Starting the route")
                .to(ExchangePattern.InOut, "spring-rabbitmq:CamelReceiverQueue?routingKey=WireTapeReceiver")
                .log("Processed the routing");

        from("spring-rabbitmq:CamelReceiverQueue?routingKey=WireTapeReceiver")
                .log("Sending message to other Queue")
                .process(sender::process)
                .log("Sent Message to Sender Queue");


    }
}
