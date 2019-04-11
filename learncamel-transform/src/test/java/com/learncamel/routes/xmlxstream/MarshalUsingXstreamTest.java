package com.learncamel.routes.xmlxstream;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXstream();
    }

    @Test
    public void marshalXsteream() throws InterruptedException {
        String input = "123,Priya,15OCT2018";
        String expectedOutput = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Priya</name><joinDate>15OCT2018</joinDate></employee>";

        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived(expectedOutput);

        template.sendBody("direct:csvInput", input);

        assertMockEndpointsSatisfied();
    }
}
