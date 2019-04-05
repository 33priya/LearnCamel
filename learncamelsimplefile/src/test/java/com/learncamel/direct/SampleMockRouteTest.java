package com.learncamel.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleMockRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleMockRouteTest() throws InterruptedException {
        String input = "Mock Route Test";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(input);

        template.sendBody("direct:sampleInput", "Mock Route Test");
        assertMockEndpointsSatisfied();
    }
}