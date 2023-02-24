package com.systudent.principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.systudent.config.KafkaConfig;

@SpringBootApplication
@Import(KafkaConfig.class)
@EnableEurekaClient
@ComponentScan("com.systudent.component")
public class LoggerkafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoggerkafkaApplication.class, args);
	}

}
