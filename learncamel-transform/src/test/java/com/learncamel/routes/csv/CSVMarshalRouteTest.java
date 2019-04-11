package com.learncamel.routes.csv;

import com.learncamel.domain.Employee;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class CSVMarshalRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarshalRoute();
    }

    @Test
    public void csvMarshalTest() {
        Employee employee = new Employee();
        employee.setId("123");
        employee.setName("Priya");
        employee.setJoinDate("15OCT2018");

        template.sendBody("direct:objInput", employee);
        File file = new File("data/csv/output");
        assertTrue(file.isDirectory());
    }
}
