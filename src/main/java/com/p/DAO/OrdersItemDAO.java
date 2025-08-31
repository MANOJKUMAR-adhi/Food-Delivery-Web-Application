package com.p.DAO;

import java.util.List;

import com.p.models.OrdersItem;

public interface OrdersItemDAO {
	
	 void addOrdersItem(OrdersItem ordersItem);
	 void updateOrdersItem(OrdersItem ordersItem);
	 void deleteOrdersItem(int id);
	 OrdersItem getOrdersItem(int id);
	 List<OrdersItem> getAllOrderItems();
	
}