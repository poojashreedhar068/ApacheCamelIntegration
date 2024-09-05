package com.routing.apachecamel.apachecamelintegration.controllers;

import com.routing.apachecamel.apachecamelintegration.entity.ApacheCamelEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("apachecamel")
public class ApacheCamelIntegrationController {


    @GetMapping("/sendmessage")
    public ResponseEntity<Object> getMessage(@RequestBody ApacheCamelEntity apacheCamelEntity) {
        log.info("getAllPoisWithinRadius(-) Started");

        return ResponseEntity.accepted().build();
    }

}
