package com.learncamel.direct;

import com.learncamel.files.CopyFilesRoute;
import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new SampleDirectRoute();
    }

    @Test
    public void sampleDirectRouteTest() throws InterruptedException {
        template.sendBody("direct:sampleInput", "Testing Direct route");
        Thread.sleep(5000);
        File fileDir = new File("sampleOutput");
        assertTrue(fileDir.isDirectory());

        Exchange exchange = consumer.receive("file:sampleOutput");
        assertEquals("output.txt", exchange.getIn().getHeader("CamelFileName"));
    }
}