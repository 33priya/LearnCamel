package com.learncamel.eips.aggregator;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;

public class AggregateWithGroupedExchangeRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:groupedExchangeAggregator")
                .log("Received message is ${body} and headers is ${header.aggregatorId}")
                .aggregate(header("aggregatorId"), new GroupedExchangeAggregationStrategy())
                .completionSize(3)
                .log("Aggregated message is ${body}")
                .to("mock:output");
    }
}
