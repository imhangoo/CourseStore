<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.imhangoo.coursestore.service.*" %>
<%@ page import="com.imhangoo.coursestore.model.*" %>

<jsp:useBean id="cart" class="com.imhangoo.coursestore.model.Cart" scope="session"></jsp:useBean>


<%
int id = Integer.parseInt(request.getParameter("id"));
CartItem item = new CartItem(id,1);
cart.add(item);
response.sendRedirect("index.jsp");
%>

