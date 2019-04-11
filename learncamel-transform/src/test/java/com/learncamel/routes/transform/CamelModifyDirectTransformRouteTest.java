package com.learncamel.routes.transform;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectTransformRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectTransformRoute();
    }

    @Test
    public void testDirectTransform() {
        String expectedOutput = "123*Line1*Test*Apache*Camel*Transform\n" + "456*Line2*Test*Apache*Camel*Transform";
        String input = "123,Line1,Test,Apache,Camel,Transform\n" + "456,Line2,Test,Apache,Camel,Transform";
        String actual = (String) template.requestBody("direct:transformInput", input);
        assertEquals(expectedOutput, actual);
    }

    @Test
    public void testDirectTransformUsingMock() throws InterruptedException {
        String expectedOutput = "123*Line1*Test*Apache*Camel*Transform\n" + "456*Line2*Test*Apache*Camel*Transform";
        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(expectedOutput);

        String input = "123,Line1,Test,Apache,Camel,Transform\n" + "456,Line2,Test,Apache,Camel,Transform";
        template.sendBody("direct:transformInput", input);

        assertMockEndpointsSatisfied();
    }
}
