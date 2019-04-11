package com.learncamel.routes.onexceptionhandler;

import com.learncamel.bean.DataModifier;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class OnExceptionHandlerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        /*onException(RuntimeException.class, Exception.class).maximumRedeliveries(2).redeliveryDelay(5000)
                .backOffMultiplier(2).log(LoggingLevel.INFO, "Exception caught in Bean");*/

        /*onException(RuntimeException.class).handled(true).maximumRedeliveries(2).delay(5000)
                .process(new GenerateErrorReponseProcessor()).log(LoggingLevel.INFO, "Exception caught in Bean");*/

        onException(RuntimeException.class).continued(true).log(LoggingLevel.INFO, "Exception caught in Bean");

        from("direct:exception")
                .bean(new DataModifier(), "mapOnException")
                .to("log:?level=INFO&showBody=true");
    }
}
