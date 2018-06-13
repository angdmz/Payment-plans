package com.project.paymentplans.configuration.log;

import com.project.paymentplans.PaymentplansApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfiguration {

    @Bean
    public Logger logger(){
        return LogManager.getLogger(PaymentplansApplication.class);
    }
}
