package com.learncamel.routes.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class XML2JSONRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new XML2JSONRoute();
    }

    @Test
    public void marshalEmployeeXML2JSON() {
        String input = "<?xml version='1.0' encoding='UTF-8'?><employee><id>123</id><name>Priya</name><joinDate>15OCT2018</joinDate></employee>";
        String expected = "{\"id\":\"123\",\"name\":\"Priya\",\"joinDate\":\"15OCT2018\"}";
        String output = template.requestBody("direct:marshalEmployeexml2json", input, String.class);
        assertEquals(expected, output);
    }

    @Test
    public void unmarshalEmployeeJSON2XML() {
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<employee><id>123</id><joinDate>15OCT2018</joinDate><name>Priya</name></employee>\r\n";
        String input = "{\"id\":\"123\",\"name\":\"Priya\",\"joinDate\":\"15OCT2018\"}";
        String output = template.requestBody("direct:unmarshalEmployeejson2xml", input, String.class);
        assertEquals(expected, output);
    }
}
