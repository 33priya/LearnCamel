package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.List;

public class CSVUnmarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnmarshalRoute();
    }

    @Test
    public void unmarshalCSV() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(3000);
        List<Employee> employees = (List<Employee>) exchange.getIn().getBody();
        assertEquals("Priya", employees.get(0).getName());
    }
}
