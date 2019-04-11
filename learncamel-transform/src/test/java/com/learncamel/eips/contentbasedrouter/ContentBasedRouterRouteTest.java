package com.learncamel.eips.contentbasedrouter;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class ContentBasedRouterRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new ContentBasedRouterRoute();
    }

    @Test
    public void contentBasedRouterTest() throws InterruptedException {
        Thread.sleep(5000);
        File htmlFile = new File("html");
        assertTrue(htmlFile.isDirectory());
        File textFile = new File("text");
        assertTrue(textFile.isDirectory());
        File jsonFile = new File("json");
        assertTrue(jsonFile.isDirectory());
        File otherFile = new File("other");
        assertTrue(otherFile.isDirectory());
        File allFile = new File("all");
        assertTrue(allFile.isDirectory());
    }
}
