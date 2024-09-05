package com.routing.apachecamel.apachecamelintegration.controllers;

import com.coding.soarearth.soarearthspringproject.Validators.SoarEarthValidator;
import com.coding.soarearth.soarearthspringproject.entity.SoarEarthPois;
import com.coding.soarearth.soarearthspringproject.model.response.GenericSuccessResponse;
import com.coding.soarearth.soarearthspringproject.service.SoarEarthPoisService;
import com.routing.apachecamel.apachecamelintegration.entity.ApacheCamelEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
