package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);
        from("direct:marshalGson")
                .log("Before marshaling is ${body}")
                .marshal(gsonDataFormat)
                .log("Marshal object is ${body}");
    }
}
