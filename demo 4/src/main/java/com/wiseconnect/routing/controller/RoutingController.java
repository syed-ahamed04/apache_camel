package com.wiseconnect.routing.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routing")
public class RoutingController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/processOrder")
    public String processOrder(@RequestBody String message) {
        producerTemplate.sendBody("direct:orderTransformation", message);
        return "Order processed by Routing Microservice: " + message;
    }
    
    @PostMapping("/processPayment")
    public String processPayment(@RequestBody String message) {
        producerTemplate.sendBody("direct:paymentTransformation", message);
        return "Payment processed by Routing Microservice: " + message;
    }
}
