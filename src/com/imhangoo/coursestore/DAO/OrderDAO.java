package com.imhangoo.coursestore.DAO;

import java.util.List;

import com.imhangoo.coursestore.model.Order;

public interface OrderDAO {
	public void save(Order order);
	public int getMaxOrderId();
	public List<Order> getOrdersByUserId(int userId);

}
