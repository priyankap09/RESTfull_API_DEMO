package com.kiranacademy.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	
	@Id
	private int productId;
	private String prodName;
	private String prodType;
	private String prodCategory;
	private double prodPrice;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
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
	public double getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", prodType=" + prodType + ", prodCategory=" + prodCategory
				+ ", prodPrice=" + prodPrice + "]";
	}
	
	
	
}
