package com.p.models;

public class OrdersItem {
	
  private int ordersItemId;
  private int ordersId;
  private int menuId;
  private int quantity;
  private int totalPrize;
  
  public OrdersItem() {
	  
  }
  
  public OrdersItem(int ordersItemId, int ordersId, int menuId, int quantity, int totalPrize) {
	
	this.ordersItemId = ordersItemId;
	this.ordersId = ordersId;
	this.menuId = menuId;
	this.quantity = quantity;
	this.totalPrize = totalPrize;
  }
 
  public OrdersItem(int ordersId, int menuId, int quantity, int totalPrize) {
	
	this.ordersId = ordersId;
	this.menuId = menuId;
	this.quantity = quantity;
	this.totalPrize = totalPrize;
}

  public int getOrdersItemId() {
	return ordersItemId;
  }

  public void setOrdersItemId(int ordersItemId) {
	this.ordersItemId = ordersItemId;
  }

  public int getOrdersId() {
	return ordersId;
  }

  public void setOrdersId(int ordersId) {
	this.ordersId = ordersId;
  }

  public int getMenuId() {
	return menuId;
  }

  public void setMenuId(int menuId) {
	this.menuId = menuId;
  }

  public int getQuantity() {
	return quantity;
  }

  public void setQuantity(int quantity) {
	this.quantity = quantity;
  }

  public int getTotalPrize() {
	return totalPrize;
  }

  public void setTotalPrize(int totalPrize) {
	this.totalPrize = totalPrize;
  }

  @Override
  public String toString() {
	return "OrdersItem [ordersItemId=" + ordersItemId + ", ordersId=" + ordersId + ", menuId=" + menuId + ", quantity="
			+ quantity + ", totalPrize=" + totalPrize + "]";
  }
  
  
  
	
	
}