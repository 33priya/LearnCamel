package com.learncamel.eips.multicast;

import org.apache.camel.builder.RouteBuilder;

public class MultiCastRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:input?noop=true")
                .multicast()
                .stopOnException()
                .parallelProcessing()
                .to("file:output1", "file:output2");
    }
}
