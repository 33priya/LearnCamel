package com.learncamel.processor;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class GenerateErrorReponseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        System.out.println("Actual Exception message: " + e.getMessage());
        System.out.println("Actual Exception class: " + e.getClass());

        String failedEndPoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("FailedEndPoint: " + failedEndPoint);

        exchange.getIn().setBody("Exception happened in the Route");
    }
}
