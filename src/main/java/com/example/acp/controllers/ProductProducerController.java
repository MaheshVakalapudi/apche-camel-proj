package com.example.acp.controllers;

import com.example.acp.models.Product;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductProducerController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/sendProduct")
    public String sendProduct(@RequestBody Product product) {
        producerTemplate.sendBody("direct:productInput", product);
        return "Product saved!";
    }
}
