package com.learncamel.routes.onexceptionhandler;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class OnExceptionHandlerRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new OnExceptionHandlerRoute();
    }

    @Test(expected = RuntimeException.class)
    public void onExceptionCheck() {
        String expectedValue = "123*Priya*15OCT2018";
        String input = null;
        String output = template.requestBody("direct:exception", input, String.class);
        assertEquals(expectedValue, output);
    }

    @Test
    public void onExceptionCheckHandled() {
        String expectedValue = "Exception happened in the Route";
        String input = null;
        String output = template.requestBody("direct:exception", input, String.class);
        assertEquals(expectedValue, output);
    }

    @Test
    public void onExceptionCheckIgnored() {
        String expectedValue = null;
        String input = null;
        String output = template.requestBody("direct:exception", input, String.class);
        assertEquals(expectedValue, output);
    }
}
