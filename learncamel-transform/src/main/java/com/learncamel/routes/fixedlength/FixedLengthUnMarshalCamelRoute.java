package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.fixed.BindyFixedLengthDataFormat;
import org.apache.camel.spi.DataFormat;

public class FixedLengthUnMarshalCamelRoute extends RouteBuilder {
    public void configure() throws Exception {
        DataFormat bindy = new BindyFixedLengthDataFormat(EmployeeWithFixedLength.class);
        from("file:data/fixedlength/input?fileName=fixedlength.txt&noop=true")
                .unmarshal(bindy)
                .log("Unmarshaled message is ${body}")
                .to("direct:output");
    }
}
