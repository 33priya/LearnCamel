package com.learncamel.routes.process;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CamelModifyDirectProcessorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectProcessorRoute();
    }

    @Test
    public void testDirectProcessor() throws InterruptedException {
        String input = "123,Line1,Test,Apache,Camel,Processor\n" + "456,Line2,Test,Apache,Camel,Processor";
        String expectedOutput = "123:Line1:Test:Apache:Camel:Processor\n" + "456:Line2:Test:Apache:Camel:Processor";

        String output = (String) template.requestBody("direct:processorInput", input);

        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertEquals(expectedOutput, output);
    }

    @Test
    public void testDirectProcessorUsingMock() throws InterruptedException {
        String expectedOutput = "123:Line1:Test:Apache:Camel:Processor\n" + "456:Line2:Test:Apache:Camel:Processor";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedOutput);

        String input = "123,Line1,Test,Apache,Camel,Processor\n" + "456,Line2,Test,Apache,Camel,Processor";
        template.sendBody("direct:processorInput", input);

        assertMockEndpointsSatisfied();
    }
}
