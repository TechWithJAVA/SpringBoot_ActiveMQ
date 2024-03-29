package com.techprimers.messaging.inmemoryactivemqexample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	 private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @JmsListener(destination = "inmemory.queue")
    public void listener(String message) {
    	log.info("Received Message: " + message);
    }
}
