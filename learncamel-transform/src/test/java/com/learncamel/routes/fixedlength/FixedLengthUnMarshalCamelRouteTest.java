package com.learncamel.routes.fixedlength;

import com.learncamel.domain.EmployeeWithFixedLength;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class FixedLengthUnMarshalCamelRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FixedLengthUnMarshalCamelRoute();
    }

    @Test
    public void fixedLengthUnMarshal() {
        Exchange exchange = consumer.receive("direct:output");
        List<EmployeeWithFixedLength> employees = (List<EmployeeWithFixedLength>) exchange.getIn().getBody();
        assertEquals("Priya", employees.get(0).getName());
        assertEquals("Victory", employees.get(1).getName());
        LocalDate expected = LocalDate.of(2018, 10, 15);
        assertEquals(expected, employees.get(0).getJoiningDate());
        assertEquals(27, employees.get(0).getAge());
        BigDecimal expectedSalary = new BigDecimal("500000.00");
        expectedSalary = expectedSalary.setScale(2, BigDecimal.ROUND_DOWN);
        assertEquals(expectedSalary, employees.get(0).getSalary());
    }
}
