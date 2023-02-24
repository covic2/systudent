package com.systudent.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.systudent.component.LoggerProducer;

@Configuration
public class GatewayConfig {
	@Autowired
	private LoggerProducer loggerProducer;
	
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		loggerProducer.sendMessage("[gateway][GatewayConfig] init gateway lb://docker-systudent-db:8086");
		
		return builder.routes()
			.route("path_route", r -> r.path("/student/*")
				.uri("lb://docker-systudent-db:8086"))
			.build();
	}
}
