package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class UnmarshalUsingGson extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);
        from("direct:unmarshalGson")
                .log("Before unmarshaling is ${body}")
                .unmarshal(gsonDataFormat)
                .log("Unmarshal object is ${body}");
    }
}
