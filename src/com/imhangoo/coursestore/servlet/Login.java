package com.imhangoo.coursestore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imhangoo.coursestore.model.User;
import com.imhangoo.coursestore.service.UserManager;

public class Login extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserManager userManager = UserManager.getInstance();
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		HttpSession hs = req.getSession();
		if("admin".equals(name)&&"admin".equals(password)){
			hs.setAttribute("admin", "admin");
			resp.sendRedirect("admin/index.jsp");
			return;
		}
		User user = userManager.validate(name, password);
		hs.setAttribute("user", user);
		resp.sendRedirect("index.jsp");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

}
