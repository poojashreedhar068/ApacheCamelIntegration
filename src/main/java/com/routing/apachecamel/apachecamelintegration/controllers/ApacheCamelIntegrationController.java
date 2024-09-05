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
    public ResponseEntity<Object> getMessage(@RequestBody ApacheCamelEntity apacheCamelEntity) {
        log.info("getAllPoisWithinRadius(-) Started");
        rabbitTemplate.convertAndSend("","WireTapeReceiver",apacheCamelEntity);
        return ResponseEntity.accepted().build();
    }

}
