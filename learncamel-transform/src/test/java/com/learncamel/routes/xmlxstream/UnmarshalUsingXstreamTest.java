package com.learncamel.routes.xmlxstream;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingXstreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshalUsingXstream();
    }

    @Test
    public void marshalXsteream() throws InterruptedException {
        String input = "<employee><id>123</id><name>Priya</name><joinDate>15OCT2018</joinDate></employee>";

        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("Priya");
        employee.setJoinDate("15OCT2018");

        MockEndpoint endpoint = getMockEndpoint("mock:output");
        endpoint.expectedBodiesReceived(employee.toString());

        template.sendBody("direct:xmlInput", input);

        assertMockEndpointsSatisfied();
    }
}