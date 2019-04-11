package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import com.learncamel.processor.CustomProcessorXstream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class MarshalUsingXstream extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:csvInput")
                .process(new CustomProcessorXstream())
                .marshal(populateXstreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }

    private XStreamDataFormat populateXstreamDef() {
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        Map<String, String> aliases = new HashMap<String, String>();
        aliases.put("employee", Employee.class.getName());

        xStreamDataFormat.setAliases(aliases);

        return xStreamDataFormat;
    }

}
