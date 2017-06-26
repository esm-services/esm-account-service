package com.esm.account.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class EsmAccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsmAccountServiceApplication.class, args);
	}
}
