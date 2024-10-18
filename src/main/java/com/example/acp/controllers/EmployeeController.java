package com.example.acp.controllers;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private ProducerTemplate producerTemplate;

    @GetMapping("/process")
    public String process(@RequestParam String name) {
        return producerTemplate.requestBody("direct:start", name, String.class);
    }
}
