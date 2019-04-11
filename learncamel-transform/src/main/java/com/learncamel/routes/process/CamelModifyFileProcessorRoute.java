package com.learncamel.routes.process;

import com.learncamel.processor.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Read file.txt is ${body} and headers is ${headers}")
                .process(new CamelFileExampleProcessor())
                .to("file.txt:data/output?fileName=output.txt")
                .to("mock:output");
    }
}
