package com.learncamel.routes.gson;

import com.learncamel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class UnmarshalUsingGsonTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnmarshalUsingGson();
    }

    @Test
    public void marshalEmployeeXML2JSON() {
        String input = "{\"id\":\"123\",\"name\":\"Priya\",\"joinDate\":\"15OCT2018\"}";
        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("Priya");
        employee.setJoinDate("15OCT2018");

        Employee employee1 = (Employee) template.requestBody("direct:unmarshalGson", input);

        assertEquals(employee.toString(), employee1.toString());
    }
}
