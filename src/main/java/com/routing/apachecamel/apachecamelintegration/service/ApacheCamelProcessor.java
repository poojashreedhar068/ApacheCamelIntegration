package com.routing.apachecamel.apachecamelintegration.service;

import com.routing.apachecamel.apachecamelintegration.entity.ApacheCamelEntity;
import com.routing.apachecamel.apachecamelintegration.repository.ApacheCamelEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ApacheCamelProcessor {

    @Autowired
    ApacheCamelEntityRepository apacheCamelEntityRepository;


    public void process(Exchange exchange) {
        log.info("Processing the message to store to DB");
        ApacheCamelEntity apacheCamelEntity = new ApacheCamelEntity();
        apacheCamelEntity.setMessage(exchange.getIn().getBody(String.class));
        apacheCamelEntityRepository.save(apacheCamelEntity);
        log.info("Message successfully stored in DB");

    }
}
