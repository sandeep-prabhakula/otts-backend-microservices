package com.sandeepprabhakula.serviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class OttShareServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OttShareServiceRegistryApplication.class, args);
	}

}
