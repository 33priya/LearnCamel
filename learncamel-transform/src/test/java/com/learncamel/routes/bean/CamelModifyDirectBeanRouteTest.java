package com.learncamel.routes.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifyDirectBeanRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifyDirectBeanRoute();
    }

    @Test
    public void testDirectBean() {
        String expectedOutput = "123*Line1*Test*Apache*Camel*Transform\n" + "456*Line2*Test*Apache*Camel*Transform";
        String input = "123,Line1,Test,Apache,Camel,Transform\n" + "456,Line2,Test,Apache,Camel,Transform";
        String actual = (String) template.requestBody("direct:beanInput", input);
        assertEquals(expectedOutput, actual);
    }
}