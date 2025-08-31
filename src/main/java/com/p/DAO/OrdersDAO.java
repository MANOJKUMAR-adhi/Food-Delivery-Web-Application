package com.p.DAO;

import java.util.List;

import com.p.models.Orders;

public interface OrdersDAO {
	
	int addOrder(Orders orders);
	void updateOrder(Orders orders);
	void deleteOrder(int id);
	Orders getOrder(int id);
	List<Orders> getAllOrders();
}