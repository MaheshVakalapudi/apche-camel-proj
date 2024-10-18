package com.example.acp.controllers;

import com.example.acp.models.Product;
import org.apache.camel.ConsumerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductConsumerController {
    @Autowired
    private ConsumerTemplate consumerTemplate;

    @GetMapping("/receiveProduct")
    public Product receiveEmployee() {
        // This assumes you're consuming from a queue or direct endpoint
        Product product = consumerTemplate.receiveBody("direct:productInput", Product.class);

        // Handle null case if no message is available
        return product != null ? product : new Product(0L, "No Product","No brand");
    }
}
