package com.p.models;

public class Restaurant {
	
	private int restaurantId;
	private String name;
	private String address;
	private String phoneNumber;
	private String rating;
	private Boolean isActive;
	private int userId;
	private String cusineType;
	private String eta;
	private String imagePath;

	public Restaurant() {
		
	}
	
	public Restaurant(int restaurantId, String name, String address, String phoneNumber, String rating,
			Boolean isActive, int userId, String cusineType, String eta, String imagePath) {
		
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.isActive = isActive;
		this.userId = userId;
		this.cusineType = cusineType;
		this.eta = eta;
		this.imagePath = imagePath;
	}

	public Restaurant(int restaurantId, String name, String address, String phoneNumber, String rating,
			Boolean isActive, int userId, String cusineType, String imagePath) {
		
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.isActive = isActive;
		this.userId = userId;
		this.cusineType = cusineType;
		this.imagePath = imagePath;
	}

	public Restaurant(String name, String address, String phoneNumber, String rating, Boolean isActive, int userId,
			String cusineType,String eta,String imagePath) {
		
		super();
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.isActive = isActive;
		this.userId = userId;
		this.cusineType = cusineType;
		this.eta = eta;
		this.imagePath = imagePath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
 
	public String getCusineType() {
		return cusineType;
	}

	public void setCusineType(String cusineType) {
		this.cusineType = cusineType;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", rating=" + rating + ", isActive=" + isActive + ", userId=" + userId + ", cusineType="
				+ cusineType + ", eta=" + eta + ", imagePath=" + imagePath + "]";
	}

	
}