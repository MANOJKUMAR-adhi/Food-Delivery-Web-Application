package com.p.models;

import java.sql.Timestamp;

public class Orders {
	
 private int orderId;
 private int userId;
 private int restaurantId;
 private Timestamp orderDate;
 private int totalAmount;
 private String status;
 private String paymentMode;
 private String Address;
 
 public Orders() {
	 
 }

 public Orders(int orderId, int userId, int restaurantId, Timestamp orderDate, int totalAmount, String status,
		String paymentMode,String Address) {
	
	 super();
	this.orderId = orderId;
	this.userId = userId;
	this.restaurantId = restaurantId;
	this.orderDate = orderDate;
	this.totalAmount = totalAmount;
	this.status = status;
	this.paymentMode = paymentMode;
	this.Address=Address;
 }
 
 public Orders(int userId, int restaurantId, int totalAmount, String status, String paymentMode,String Address) {
	
	 super();
	this.userId = userId;
	this.restaurantId = restaurantId;
	this.totalAmount = totalAmount;
	this.status = status;
	this.paymentMode = paymentMode;
	this.Address=Address;
}
 
 public int getOrderId() {
	return orderId;
 }
 
 public void setOrderId(int orderId) {
	this.orderId = orderId;
 }
 
 public int getUserId() {
	return userId;
 }
 
 public void setUserId(int userId) {
	this.userId = userId;
 }
 
 public int getRestaurantId() {
	return restaurantId;
 }
 
 public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
 }
 
 public Timestamp getOrderDate() {
	return orderDate;
 }
 
 public void setOrderDate(Timestamp orderDate) {
	this.orderDate = orderDate;
 }
 
 public int getTotalAmount() {
	return totalAmount;
 }
 
 public void setTotalAmount(int totalAmount) {
	this.totalAmount = totalAmount;
 }
 
 public String getStatus() {
	return status;
 }
 
 public void setStatus(String status) {
	this.status = status;
 }
 
 public String getPaymentMode() {
	return paymentMode;
 }
 
 public void setPaymentMode(String paymentMode) {
	this.paymentMode = paymentMode;
 }
 
 public String getAddress() {
	return Address;
}
 
 public void setAddress(String address) {
	Address = address;
 }
 
 @Override
 public String toString() {
	return "Orders [orderId=" + orderId + ", userId=" + userId + ", restaurantId=" + restaurantId + ", orderDate="
			+ orderDate + ", totalAmount=" + totalAmount + ", status=" + status + ", paymentMode=" + paymentMode + "]";
 }
 
 
}