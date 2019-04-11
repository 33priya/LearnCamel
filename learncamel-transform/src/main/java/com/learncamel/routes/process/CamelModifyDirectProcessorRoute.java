package com.learncamel.routes.process;

import com.learncamel.processor.CamelDirectExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyDirectProcessorRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:processorInput")
                .log("Received Message before process is ${body} and headers is ${headers}")
                .process(new CamelDirectExampleProcessor())
                .log("Received Message after process is ${body} and headers is ${headers}")
//                .to("file.txt:data/output?fileName=output.txt");
                .to("mock:output");
    }
}
