<%@page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>

<%@ page import="com.imhangoo.coursestore.service.*" %>
<%
// get user info and register to database
request.setCharacterEncoding("utf-8");
String submit = request.getParameter("submit");
if(submit!=null&&"submit".equals(submit)){
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	UserManager userManager = UserManager.getInstance();
	userManager.save(name, password, email);
	response.sendRedirect("index.jsp");
}

%>



<jsp:include page="header.jsp"></jsp:include>

<div class="signup-form container">
	<form role="form" action="signup.jsp">
	  <input type="hidden" name="submit" value="submit">
	  <div class="form-group">
	    <label for="name">User Name:</label>
	    <input type="text" name="name" class="form-control" id="name">
	  </div>
	  <div class="form-group">
	    <label for="email">Email:</label>
	    <input type="text" name="email" class="form-control" id="email">
	  </div>
	  
	  <div class="form-group">
	    <label for="password">Password:</label>
	    <input type="password" name="password" class="form-control" id="password">
	  </div>
	  
	   <div class="form-group">
	    <label for="password2">Confirm:</label>
	    <input type="password" name="password2" class="form-control" id="password2">
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
	
</div>

</body>

</html>