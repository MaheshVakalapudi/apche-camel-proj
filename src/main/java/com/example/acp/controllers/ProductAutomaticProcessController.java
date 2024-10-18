package com.example.acp.controllers;

import com.example.acp.models.Product;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductAutomaticProcessController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping("/processProductAutomatically")
    public String processEmployee(@RequestBody Product product) {
        String result = producerTemplate.requestBody("direct:productProcess", product, String.class);
        return result != null ? result : "Processing failed";
    }
}
