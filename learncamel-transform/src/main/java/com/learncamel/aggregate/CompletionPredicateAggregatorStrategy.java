package com.learncamel.aggregate;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class CompletionPredicateAggregatorStrategy implements AggregationStrategy {
    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
        if (oldExchange != null) {
            String oldExchangeValue = (String) oldExchange.getIn().getBody();
            String newExchangeValue = (String) newExchange.getIn().getBody();

            newExchangeValue = oldExchangeValue.concat(":").concat(newExchangeValue);

            newExchange.getIn().setBody(newExchangeValue);
        }
        return newExchange;
    }
}

