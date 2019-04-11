package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.spi.DataFormat;

public class CSVUnmarshalRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        DataFormat bindy = new BindyCsvDataFormat(Employee.class);
        from("file:data/csv/input?fileName=input_file.txt&noop=true")
                .unmarshal(bindy)
                .log("Unmarshaled message is ${body}")
                .to("direct:output");
    }
}
