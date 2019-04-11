package com.learncamel.eips.multicast;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class MultiCastRouterTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MultiCastRouter();
    }

    @Test
    public void multiCastRouteTest() throws InterruptedException {
        Thread.sleep(5000);
        File file1 = new File("output1");
        assertTrue(file1.isDirectory());
        File file2 = new File("output2");
        assertTrue(file2.isDirectory());
    }
}
