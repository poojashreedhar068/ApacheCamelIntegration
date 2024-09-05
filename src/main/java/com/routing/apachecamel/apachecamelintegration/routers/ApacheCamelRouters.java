package com.routing.apachecamel.apachecamelintegration.routers;

import org.apache.camel.ExchangePattern;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApacheCamelRouters extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        from("direct:start")
                .log("Starting the route")
                .to(ExchangePattern.InOut, "spring-rabbitmq:WireTapeReceiver?routingKey=WireTapeReceiver")
                .log("Processed the routing");

        from("spring-rabbitmq:WireTapeReceiver?routingKey=WireTapeReceiver")
                .log("Sending message to other Queue")
                .to("spring-rabbitmq:WireTapeReceiver?queues=WireTapeSender&routingKey=WireTapReceiver")
                .log("Sent Message to Other Queue");


    }
}
