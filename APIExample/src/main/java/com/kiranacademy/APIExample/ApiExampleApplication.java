package com.kiranacademy.APIExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.kiranacademy.controller.Customer;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class ApiExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiExampleApplication.class, args);
		System.out.println("Spring boot app is runing");
		System.out.println("Learning Spring Boot...");
		
//		String t =  "RS Logan week 11";
//		
//		if(!t.toUpperCase().contains("LOGAN"))
//			System.out.println("PROCEED");
//		else
//			System.out.println("INVALID TEAM");
	}
	
	@Bean("first")
	 public Customer getMeObject() {
		
		Customer customer = new Customer();
		customer.setCid(101);
		return customer;
	}
	@Bean("second")
	 public Customer getMeObject2() {
		
		Customer customer = new Customer();
		customer.setCid(202);
		return customer;
	}


}
