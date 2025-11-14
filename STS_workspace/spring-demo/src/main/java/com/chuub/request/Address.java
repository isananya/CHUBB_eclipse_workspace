package com.chuub.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Address {
	@NotBlank
	private String house;
	@Min(value=1)
	private int pin;
	
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}
