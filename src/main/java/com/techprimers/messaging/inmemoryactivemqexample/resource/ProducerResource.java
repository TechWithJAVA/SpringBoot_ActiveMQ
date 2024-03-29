package com.techprimers.messaging.inmemoryactivemqexample.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    private static final Logger log = LoggerFactory.getLogger(ProducerResource.class);
    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final
                          String message) {

        jmsTemplate.convertAndSend(queue, message);
      
       log.info("Producer message"+ message);
        return "Published Successfully";
    }
}
