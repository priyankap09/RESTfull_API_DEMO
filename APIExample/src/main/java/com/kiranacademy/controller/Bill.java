package com.kiranacademy.controller;

public class Bill {
	
	private int productId;
	private String name;
	private String prodType;
	private String prodCategory;
	private double basePrice;
	private double discount;
	private Charges charges;
	private double finalPrice;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int product_id) {
		this.productId = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	public String getProdCategory() {
		return prodCategory;
	}
	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Charges getCharges() {
		return charges;
	}
	public void setCharges(Charges charges) {
		this.charges = charges;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	
	
	@Override
	public String toString() {
		return "Bill [product_id=" + productId + ", name=" + name + ", prodType=" + prodType + ", prodCategory="
				+ prodCategory + ", basePrice=" + basePrice + ", discount=" + discount + ", charges=" + charges
				+ ", finalPrice=" + finalPrice + "]";
	}
	
	

}
