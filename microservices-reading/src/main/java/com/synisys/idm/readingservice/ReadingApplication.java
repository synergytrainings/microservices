package com.synisys.idm.readingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

@EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
//@IntegrationComponentScan
@ImportResource("classpath:application-config.xml")
@EnableFeignClients
public class ReadingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReadingApplication.class, args);
	}
}
