package com.learncamel.eips.aggregator;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AggregatorRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new AggregatorRoute();
    }

    @Test
    public void aggregateRouteTest() throws InterruptedException {
        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived("123");

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void aggregateMultipleMessages() throws InterruptedException {
        MockEndpoint endpoint = getMockEndpoint("mock:output");
        List<String> expectedValueList = new ArrayList<>();
        expectedValueList.add("123");
        expectedValueList.add("567");

        endpoint.expectedBodiesReceived(expectedValueList);

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "5", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "6", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "7", "aggregatorId", 1);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void aggregateMultipleMessagesWithDiffAggregateId() throws InterruptedException {
        MockEndpoint endpoint = getMockEndpoint("mock:output");
        List<String> expectedValueList = new ArrayList<>();
        expectedValueList.add("123");
        expectedValueList.add("456");

        endpoint.expectedBodiesReceived(expectedValueList);

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "5", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "6", "aggregatorId", 2);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void aggregateMessageTimeout() throws InterruptedException {
        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived("12");

        template.sendBodyAndHeader("direct:simpleAggregator", "1", "aggregatorId", 1);
        template.sendBodyAndHeader("direct:simpleAggregator", "2", "aggregatorId", 1);
        Thread.sleep(5000);
        template.sendBodyAndHeader("direct:simpleAggregator", "4", "aggregatorId", 2);
        template.sendBodyAndHeader("direct:simpleAggregator", "3", "aggregatorId", 1);

        assertMockEndpointsSatisfied();
    }
}