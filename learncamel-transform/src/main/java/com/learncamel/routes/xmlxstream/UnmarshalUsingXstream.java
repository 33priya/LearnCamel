package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import com.learncamel.processor.CustomProcessorXstream;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class UnmarshalUsingXstream extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:xmlInput")
                .unmarshal(populateXstreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }

    private XStreamDataFormat populateXstreamDef() {
        Map<String, String> aliases = new HashMap<String, String>();
        aliases.put("employee", Employee.class.getName());
        XStreamDataFormat xStreamDataFormat = new XStreamDataFormat();
        xStreamDataFormat.setAliases(aliases);
        xStreamDataFormat.setPermissions(Employee.class.getName());

        return xStreamDataFormat;
    }

}

