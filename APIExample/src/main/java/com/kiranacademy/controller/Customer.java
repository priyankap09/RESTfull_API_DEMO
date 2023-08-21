package com.kiranacademy.controller;

import org.springframework.stereotype.Component;

//@Component
public class Customer {

	private int cid;
	
	
	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public String getCustomerName() {
		return "Priyanka Patil";
	}
}
