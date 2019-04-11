package com.learncamel.processor;

import org.apache.camel.Exchange;

public class RecipientListProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String type = exchange.getIn().getHeader("type", String.class);

        if (type.equals("senior")) {
            exchange.getIn().setHeader("type", "file:xmlSenior");
        } else if (type.equals("junior")) {
            exchange.getIn().setHeader("type", "file:xmlJunior");
        }
    }
}
