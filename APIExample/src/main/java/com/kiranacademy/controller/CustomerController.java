package com.kiranacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	@Qualifier("second")
	Customer customer;
	
	@RequestMapping("getName")
	public String getName() {
		//Customer customer = new Customer();// not needed this as it is done by @Autowired
		String name = customer.getCustomerName();
		return name+ " cid:"+customer.getCid();
	}

}
