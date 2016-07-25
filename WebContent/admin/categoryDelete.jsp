<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.imhangoo.coursestore.model.*,com.imhangoo.coursestore.service.*,
				java.util.*,java.text.*" %>  

<%
String idStr = request.getParameter("id");
if(idStr==null) return;
int id = Integer.parseInt(idStr);
CategoryManager categoryManager = CategoryManager.getInstance();
categoryManager.delete(id);
response.sendRedirect("category.jsp");
%>