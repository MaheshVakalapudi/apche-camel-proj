package com.example.acp.Builders;

import com.example.acp.models.Product;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProductAutomaticRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
       /* from("direct:employeeInput")
                .log("Received Employee: ID=${body.id}, Name=${body.name}")
                .to("log:employeeLog");*/

        // Optionally, you can add another route to handle specific processing for consumed employees
        from("direct:productProcess")
                .process(exchange -> {
                    Product employee = exchange.getIn().getBody(Product.class);
                    // Further processing can be done here
                    exchange.getIn().setBody("Processed Product: " + employee.getName());
                })
                .log("Processed Product: ${body}")
                .to("log:employeeLog");
    }
}
