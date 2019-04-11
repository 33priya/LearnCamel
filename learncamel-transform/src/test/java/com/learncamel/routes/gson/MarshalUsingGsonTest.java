package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class MarshalUsingGsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void marshalEmployeeXML2JSON() {
        String expected = "{\"id\":\"123\",\"name\":\"Priya\",\"joinDate\":\"15OCT2018\"}";
        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("Priya");
        employee.setJoinDate("15OCT2018");

        String output = template.requestBody("direct:marshalGson", employee, String.class);

        assertEquals(expected, output);
    }
}
