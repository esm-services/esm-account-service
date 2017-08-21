package com.esm.account.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ESMAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ESMAccountServiceApplication.class, args);
	}
}
