package com.learncamel.eips.aggregator;

import com.learncamel.aggregate.CompletionPredicateAggregatorStrategy;
import org.apache.camel.builder.RouteBuilder;

public class AggregatorCompletionPredicateRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:completionPredicateAggregator")
                .log("Received message is ${body} and key{header.aggregatorId}")
                .aggregate(header("aggregatorId"), new CompletionPredicateAggregatorStrategy())
                .completionPredicate(body().contains("order-confirm"))
                .log("Aggregated message is ${body}")
                .eagerCheckCompletion()
                .to("mock:output");
    }
}
