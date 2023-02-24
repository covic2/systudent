package com.systudent.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.systudent.config.KafkaConfig;

@SpringBootApplication

@ComponentScan({"com.systudent.controller","com.systudent.service","com.systudent.model","com.systudent.component"})
@Import(KafkaConfig.class)
@EnableEurekaClient
//@ComponentScan({"com.systudent"})
@EnableJpaRepositories({"com.systudent.dao"})
@EntityScan("com.systudent.model")
public class SystudentDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystudentDbApplication.class, args);
	}

}
