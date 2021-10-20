package com.leidos.rest.code.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.leidos.rest.code.sample.customer.repository.CustomerRepository;

@SpringBootApplication
public class CustomerApplication {

	@Autowired
	CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}
}
