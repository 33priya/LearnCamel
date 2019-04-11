package com.learncamel.routes.csv;

import com.learncamel.domain.Address;
import com.learncamel.domain.Employee;
import com.learncamel.domain.EmployeeWithAddress;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class CSVMarshalWithLinkRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CSVMarshalWithLinkRoute();
    }

    @Test
    public void csvMarshalTest() {
        EmployeeWithAddress employee = new EmployeeWithAddress();
        employee.setId("1");
        employee.setName("Priya");
        employee.setJoinDate("15OCT2018");

        Address address = new Address();
        address.setAddressLine("AssetzEastPoint");
        address.setCity("Bengaluru");
        address.setState("Karnataka");
        address.setZip("560103");
        address.setCountry("India");
        employee.setAddress(address);

        template.sendBody("direct:objInput", employee);

        File file = new File("data/csv/output/output_with_address.txt");
        assertTrue(file.exists());
    }
}
