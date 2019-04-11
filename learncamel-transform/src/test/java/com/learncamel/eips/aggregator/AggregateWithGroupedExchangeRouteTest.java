package com.learncamel.eips.aggregator;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class AggregateWithGroupedExchangeRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregateWithGroupedExchangeRoute();
    }

    @Test
    public void aggregateRouteTest() throws InterruptedException {
        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedMessageCount(1);

        template.sendBodyAndHeader("direct:groupedExchangeAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:groupedExchangeAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:groupedExchangeAggregator", "3", "aggregatorId", 1);

        assertMockEndpointsSatisfied();

        Exchange exchange = endpoint.getExchanges().get(0);
        List<Exchange> exchanges = (List<Exchange>) exchange.getProperty(Exchange.GROUPED_EXCHANGE);
        for (Exchange receivedExchange : exchanges) {
            System.out.println("Received body is : " + receivedExchange.getIn().getBody());
        }
    }

}