package com.learncamel.eips.recipientlist;

import com.learncamel.processor.RecipientListProcessor;
import org.apache.camel.builder.RouteBuilder;

public class RecipientListRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:xmlInput?noop=true")
                .setHeader("type", xpath("/employee/@type"))
                .process(new RecipientListProcessor())
                .recipientList(header("type"));
    }
}
