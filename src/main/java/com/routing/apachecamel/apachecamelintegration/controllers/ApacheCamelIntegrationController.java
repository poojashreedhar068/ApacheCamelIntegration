package com.routing.apachecamel.apachecamelintegration.controllers;

import com.routing.apachecamel.apachecamelintegration.entity.ApacheCamelEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("apachecamel")
public class ApacheCamelIntegrationController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/sendmessage")
    public ResponseEntity<Object> sendMessage(@RequestBody String message) {
        log.info("Sending the message to queue :: "+ message);
        rabbitTemplate.convertAndSend("CamelReceiverQueue", message);
        return ResponseEntity.ok().build();

    }

}
