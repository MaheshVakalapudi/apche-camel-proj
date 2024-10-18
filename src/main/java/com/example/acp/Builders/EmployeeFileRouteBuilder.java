package com.example.acp.Builders;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class EmployeeFileRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:input?noop=true") // Read files from the "input" directory
                .log("Processing file: ${header.CamelFileName}")
                .to("file:output"); // Write processed files to the "output" directory
    }
}
