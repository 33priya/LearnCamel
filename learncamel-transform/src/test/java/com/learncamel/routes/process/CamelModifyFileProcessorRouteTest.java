package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void testProcessFile() throws InterruptedException {
        String expectedResult = "123:Line1:Test:Apache:Camel:Processor\n" + "456:Line2:Test:Apache:Camel:Processor\n";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedResult);

        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();
    }
}
