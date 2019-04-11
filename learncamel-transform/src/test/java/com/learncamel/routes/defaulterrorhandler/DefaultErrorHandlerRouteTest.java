package com.learncamel.routes.defaulterrorhandler;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class DefaultErrorHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void checkException() {
        String expectedValue = "123*Priya*15OCT2018";
        String input = null;
        String output = template.requestBody("direct:exception", input, String.class);
        assertEquals(expectedValue, output);
    }
}
