package com.learncamel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.file.GenericFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CamelFileExampleProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {
        GenericFile<File> file = (GenericFile<File>) exchange.getIn().getBody();
        if (file != null) {
            FileReader fileReader = new FileReader(file.getFile());
            BufferedReader reader = new BufferedReader(fileReader);
            String readLine = null;
            String newValue = "";
            while ((readLine = reader.readLine()) != null) {
                newValue = newValue.concat(readLine.replace(",", ":")).concat("\n");
                exchange.getOut().setBody(newValue);
            }
        }
    }
}
