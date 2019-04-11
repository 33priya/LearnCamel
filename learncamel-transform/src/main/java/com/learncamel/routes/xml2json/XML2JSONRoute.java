package com.learncamel.routes.xml2json;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

public class XML2JSONRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:marshalEmployeexml2json")
                .log("log:?level=INFO&showBody=true")
                .marshal().xmljson()
                .log("log:?level=INFO&showBody=true");

        XmlJsonDataFormat xmlJsonDataFormat = new XmlJsonDataFormat();
        xmlJsonDataFormat.setRootName("employee");

        from("direct:unmarshalEmployeejson2xml")
                .log("log:?level=INFO&showBody=true")
                .unmarshal(xmlJsonDataFormat)
                .log("log:?level=INFO&showBody=true");
    }
}
