package com.example.acp.Builders;

import com.example.acp.models.Product;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class ProductRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:productInput")
                .log("Received Product: ID=${body.id}, Name=${body.name}")
                .to("log:employeeLog");
    }










    /*@Override
    public void configure() {
        // Route to process the data
        from("direct:productInput")
                .routeId("dataProcessingRoute")
                .process(exchange -> {
                    // Access the body as a Product object
                    Product product = exchange.getIn().getBody(Product.class);

                    // Check for null and process the product
                    if (product != null) {
                        // Modify product (for example, add a brand)
                        product.setBrand("Samsung"); // Assuming setBrand() method exists
                        exchange.getIn().setBody(product); // Set it back if needed
                    } else {
                        throw new IllegalArgumentException("Product cannot be null");
                    }
                }).to("log:employeeLog");
    }*/

};

