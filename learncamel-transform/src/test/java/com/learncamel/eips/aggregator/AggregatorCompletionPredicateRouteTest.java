package com.learncamel.eips.aggregator;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class AggregatorCompletionPredicateRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorCompletionPredicateRoute();
    }

    @Test
    public void completionPredicateTest() throws InterruptedException {
        MockEndpoint endpoint = getMockEndpoint("mock:output");

        String msg1 = "12345, samsung-phone, order-created";
        String msg2 = "12345, samsung-phone, order-confirm";

        String expectedValue = msg1.concat(":").concat(msg2);
        endpoint.expectedBodiesReceived(expectedValue);

        template.sendBodyAndHeader("direct:completionPredicateAggregator", msg1, "aggregatorId", 12345);
        template.sendBodyAndHeader("direct:completionPredicateAggregator", msg2, "aggregatorId", 12345);

        assertMockEndpointsSatisfied();
    }

}
