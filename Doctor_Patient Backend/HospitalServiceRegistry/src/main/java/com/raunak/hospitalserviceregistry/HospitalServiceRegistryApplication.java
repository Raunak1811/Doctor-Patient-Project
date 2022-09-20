package com.raunak.hospitalserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HospitalServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalServiceRegistryApplication.class, args);
	}

}
