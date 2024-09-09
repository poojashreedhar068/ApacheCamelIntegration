package com.routing.apachecamel.apachecamelintegration.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQListner {

    @Autowired
    ProducerTemplate producerTemplate;

    @RabbitListener(queues = {"CamelReceiverQueue"})
    public void listner(String object){
        log.info("Received message from Queue");
        log.info(object);
        producerTemplate.sendBody("spring-rabbitmq:CamelReceiverQueue?routingKey=WireTapeReceiver", object);
    }
}
