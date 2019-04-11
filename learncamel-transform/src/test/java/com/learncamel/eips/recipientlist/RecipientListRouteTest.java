package com.learncamel.eips.recipientlist;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class RecipientListRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RecipientListRoute();
    }

    @Test
    public void recipientListRouteTest() throws InterruptedException {
        Thread.sleep(5000);
        File file1 = new File("xmlSenior");
        assertTrue(file1.isDirectory());
        File file2 = new File("xmlJunior");
        assertTrue(file2.isDirectory());
    }
}