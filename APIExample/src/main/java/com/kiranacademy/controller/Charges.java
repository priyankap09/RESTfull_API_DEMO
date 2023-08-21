package com.kiranacademy.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Charges {


	private double gst;
	private double deliveryCharges;
	
	


	public double getGst() {
		return gst;
	}



	public void setGst(double gst) {
		this.gst = gst;
	}



	public double getDeliveryCharges() {
		return deliveryCharges;
	}



	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}



	@Override
	public String toString() {
		return "ProductDetails [  gst=" + gst
				+ ", deliverycharges=" + deliveryCharges + "]";
	}
	
	
	
	
}
