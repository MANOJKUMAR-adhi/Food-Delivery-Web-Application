package com.p.models;

public class CartItem {

	int itemId;
	String name;
	int price;
	int quantity;
	int restaurantId;
	int totalPrice;
	
	public CartItem() {
		
	}

	public CartItem(int itemId, String name, int price, int quantity, int restaurantId, int totalPrice) {
		
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.restaurantId = restaurantId;
		this.totalPrice = totalPrice;
	}

	public CartItem(int itemId,int restaurantId,String name,int quantity) {
		
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		
	}

	public CartItem(int itemId, int restaurantId, String name, int quantity, int price) {
		
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", restaurantId=" + restaurantId + ", totalPrice=" + totalPrice + "]";
	}
}