package com.chuub.request;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Order1 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();
	
	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	public void addItem(Item item) {
        items.add(item);
        item.setOrder(this);
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	@NotBlank
//	private String item;
//	@Min(value=1)
//	private float price;
////	@Min(value=2, message="min quantity=2")
//	@Range(min=2,max=10)
//	private int quantity;
////	@Valid private Address address;
////	public Address getAddress() {
////		return address;
////	}
////	public void setAddress(Address address) {
////		this.address = address;
////	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	public String getItem() {
//		return item;
//	}
//	public void setItem(String item) {
//		this.item = item;
//	}
//	public float getPrice() {
//		return price;
//	}
//	public void setPrice(float price) {
//		this.price = price;
//	}
//	public float calculatePrice() {
//		return price*quantity;
//	}
	
}
