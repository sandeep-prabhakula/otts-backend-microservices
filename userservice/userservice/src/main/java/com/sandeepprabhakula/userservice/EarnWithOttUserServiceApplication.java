package com.sandeepprabhakula.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EarnWithOttUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EarnWithOttUserServiceApplication.class, args);
	}

}
