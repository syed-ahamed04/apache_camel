package com.wiseconnect.adapter.controller;

import org.springframework.web.bind.annotation.*;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/adapter")
public class AdapterController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/process")
    public String processMessage(@RequestBody String message) {
        // Send the message to the appropriate route
        if (message.contains("order")) {
            producerTemplate.sendBody("direct:orderTransformation", message);
        } else if (message.contains("payment")) {
            producerTemplate.sendBody("direct:paymentTransformation", message);
        } else {
            return "Invalid JSON type";
        }
        return "Message processed by Adapter Microservice: " + message;
    }
}
