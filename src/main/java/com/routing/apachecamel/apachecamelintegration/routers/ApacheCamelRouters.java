package com.routing.apachecamel.apachecamelintegration.routers;

import com.routing.apachecamel.apachecamelintegration.sender.ApacheCamelSender;
import com.routing.apachecamel.apachecamelintegration.service.ApacheCamelProcessor;
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

    @Autowired
    ApacheCamelProcessor apacheCamelProcessor;


    @Override
    public void configure() throws Exception {

        from("direct:start")
                .log("Starting the route")
                .wireTap("direct:queueProcessor")
                .to("direct:databaseProcess")
                       .log("Done with Processing");

        from("direct:queueProcessor")
                .delay(1000)
                .log("Sending message to sender Queue")
                .process(sender::process)
                .log("Sent Message to Sender Queue");

        from("direct:databaseProcess")
                .log("Storing the message to DB")
                .process(apacheCamelProcessor::process)
                .log("Message is successfully stored to DB");


    }
}
