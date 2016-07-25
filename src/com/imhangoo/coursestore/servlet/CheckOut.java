package com.imhangoo.coursestore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imhangoo.coursestore.model.Cart;
import com.imhangoo.coursestore.model.OrderHeader;

public class CheckOut extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession hs = req.getSession();
		Cart cart = (Cart)hs.getAttribute("cart");
		String userName = (String)hs.getAttribute("login");
		System.out.println(userName);
		OrderHeader oh = new OrderHeader();
		
	}
	

}
