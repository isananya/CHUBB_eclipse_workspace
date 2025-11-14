package com.chuub.request;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Order {
	@NotBlank
	private String item;
	@Min(value=1)
	private float price;
//	@Min(value=2, message="min quantity=2")
	@Range(min=2,max=10)
	private int quantity;
	@Valid private Address address;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float calculatePrice() {
		return price*quantity;
	}
	
}
