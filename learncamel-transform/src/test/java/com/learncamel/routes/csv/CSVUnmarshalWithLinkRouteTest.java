package com.learncamel.routes.csv;

import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CSVUnmarshalWithLinkRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVUnmarshalWithLinkRoute();
    }

    @Test
    public void unmarshalCSVWithLink() throws InterruptedException {
        Exchange exchange = consumer.receive("direct:output");
        Thread.sleep(3000);
        EmployeeWithAddress employeeWithAddress = (EmployeeWithAddress) exchange.getIn().getBody();
        assertEquals("Bengaluru", employeeWithAddress.getAddress().getCity());
    }
}
