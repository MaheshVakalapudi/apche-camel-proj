package com.example.acp.Builders;

import com.example.acp.components.EmployeeBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EmployeeRouteBuilder extends RouteBuilder {

   /* @Override
    public void configure() throws Exception {
        from("direct:nameBuilder")
                .log("Given name: ${body}") // Log the incoming name
                .setBody(simple("Name Received as: ${body}")); // Set the response
    }*/

























    //example: 2 To read Bean object data into camel body and log
    @Override
    public void configure() throws Exception {
        from("direct:start")
                .bean(EmployeeBean.class, "getAddress")
                .to("log:result");
    }














   //example: 3 To send response for request GET: http://localhost:9090/apacheCamelDemo/process?name=Revanth
/*    @Override
    public void configure() throws Exception {
        from("direct:start")
                .process(exchange -> {
                    String name = exchange.getIn().getBody(String.class);
                    String response = "Given name: " + name;
                    exchange.getIn().setBody(response);
                }).to("log:result");
    }*/


}
