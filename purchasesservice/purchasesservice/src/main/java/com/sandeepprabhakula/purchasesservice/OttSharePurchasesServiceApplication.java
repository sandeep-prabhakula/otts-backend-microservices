package com.sandeepprabhakula.purchasesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OttSharePurchasesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttSharePurchasesServiceApplication.class, args);
	}

}
