package com.kiranacademy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "charges")
public class ProductCharges {
	
	@Id
	private String prodCategory;
	private double gst;
	private double deliveryCharges;
	private double discount;
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
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
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "ProductCharges [prodCategory=" + prodCategory + ", gst=" + gst + ", deliveryCharges=" + deliveryCharges
				+ ", discount=" + discount + "]";
	}

	
	

}
