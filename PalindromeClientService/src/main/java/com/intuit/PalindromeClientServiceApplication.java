package com.intuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class PalindromeClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalindromeClientServiceApplication.class, args);
	}
}
