package com.project.paymentplans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PaymentplansApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentplansApplication.class, args);
	}
}
