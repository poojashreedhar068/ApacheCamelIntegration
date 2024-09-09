package com.routing.apachecamel.apachecamelintegration.sender;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApacheCamelSender {

    @Autowired
    ProducerTemplate producerTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void process(Exchange exchange) {
        log.info("Received the Message from Queue to be processed");
        log.info("Received Message is :: "+ exchange.getIn().getBody());
        rabbitTemplate.convertAndSend("CamelSenderQueue",exchange.getIn().getBody());
    }
}
