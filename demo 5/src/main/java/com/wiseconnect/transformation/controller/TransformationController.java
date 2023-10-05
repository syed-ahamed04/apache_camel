package com.wiseconnect.transformation.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transformation")
public class TransformationController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/process")
    public String processMessage(@RequestBody String message) {
        producerTemplate.sendBody("direct:transformation", message);
        return "Message processed by Transformation Microservice: " + message;
    }
}
