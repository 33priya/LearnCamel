package com.learncamel.eips.aggregator;

import com.learncamel.aggregate.AggregatorRouteStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:simpleAggregator")
                .log("Received message is ${body} and key{header.aggregatorId}")
                .aggregate(header("aggregatorId"), new AggregatorRouteStrategy())
                .completionSize(3)
//                .completionTimeout(3000)
                .log("Aggregated message is ${body}")
                .to("mock:output");
    }
}
