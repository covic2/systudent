package com.systudent.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SystudentDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystudentDiscoveryApplication.class, args);
	}

}
