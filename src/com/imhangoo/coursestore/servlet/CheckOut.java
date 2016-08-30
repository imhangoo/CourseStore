package com.imhangoo.coursestore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imhangoo.coursestore.model.Cart;
import com.imhangoo.coursestore.model.Order;
import com.imhangoo.coursestore.model.User;
import com.imhangoo.coursestore.service.OrderManager;

public class CheckOut extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//get cart and user in session
		HttpSession hs = req.getSession();
		Cart cart = (Cart)hs.getAttribute("cart");
		User user = (User)hs.getAttribute("user");
		// convert cart to order
		OrderManager orderManager = OrderManager.getInstance();
		Order order = orderManager.cartToOrder(cart);
		order.setCustomerID(user.getId());

		orderManager.save(order);
		hs.removeAttribute("cart");
		resp.sendRedirect("orderList.jsp");
		
	}
	

}
