package com.imhangoo.coursestore.service;

import java.util.ArrayList;
import java.util.List;

import com.imhangoo.coursestore.DAO.OrderDAO;
import com.imhangoo.coursestore.DAO.impl.MysqlOrderDAO;
import com.imhangoo.coursestore.model.Cart;
import com.imhangoo.coursestore.model.CartItem;
import com.imhangoo.coursestore.model.Order;
import com.imhangoo.coursestore.model.OrderItem;

public class OrderManager {
	private OrderDAO dao = null;
	public static OrderManager orderManager = null;

	private OrderManager() {
		dao = MysqlOrderDAO.getInstance();
	}

	// Singleton
	public static OrderManager getInstance() {
		if (orderManager == null) {
			orderManager = new OrderManager();
		}
		return orderManager;
	}

	public Order cartToOrder(Cart cart) {
		int orderId = dao.getMaxOrderId() + 1;
		Order order = new Order(orderId);
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		List<CartItem> cartItems = cart.getItems();

		for (CartItem ci : cartItems) {
			OrderItem oi = new OrderItem();
			oi.setOrderID(orderId);
			oi.setCourse(ci.getCourse());
			oi.setQuantity(ci.getQuantity());
			orderItems.add(oi);
		}

		order.setItems(orderItems);
		return order;

	}

	public void save(Order order) {
		dao.save(order);
	}

	public List<Order> getOrdersByUserId(int userId) {
		return dao.getOrdersByUserId(userId);
	}

}
