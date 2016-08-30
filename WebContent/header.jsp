<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.imhangoo.coursestore.service.*" %>
<%@ page import="com.imhangoo.coursestore.model.*" %>
<%@ page import="java.util.*" %>

<%
User user = (User)session.getAttribute("user");
String admin = (String)session.getAttribute("admin");
String logout = request.getParameter("logout");
// logout & reset login
if(logout!=null && "true".equals(logout)){
	if(user!=null){
		session.removeAttribute("user");
	}
	if(admin!=null){
		session.removeAttribute("admin");
	}
	user = null;
	admin = null;
}

Cart cart = (Cart)session.getAttribute("cart");

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Course Store</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="img/favicon.ico" type="image/x-icon">

</head>


<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">Home</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li ><a href="#">Java</a></li>
                <li><a href="#">C++</a></li>
                <li><a href="#" class="active">Python</a></li>
                <li><a href="#" class="active">JavaScript</a></li>
            </ul>
            <% if(user==null && admin==null){%>
            <form action="login" class="navbar-form navbar-right" role="form">
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="User Name">
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="Password">
                </div>
                <button type="submit" class="btn btn-success">Log in</button>
                <a href="signup.jsp" class="btn btn-success">Sign up</a>
              	<%if(cart!=null){%>
             	 	<a href="cartList.jsp" class="btn btn-md btn-success">Cart(<%=cart.getSize()%>)</a>
            	 	&nbsp
           		 	 <%}%>
            </form>
            <%}else{ %>
             <div class="head_nav">
             <%if("admin".equals(admin)){%>
             <a href="admin/index.jsp"> Return Backstage</a>&nbsp
             <a href="?logout=true"> logout</a>
             <%}else{ %>
             <span>Hello,&nbsp </span>
             <a href="#">${sessionScope.user.name}</a>&nbsp
             <%
            	 if(cart!=null){%>
             	 	<a href="cartList.jsp" class="btn btn-md btn-success">Cart(<%=cart.getSize()%>)</a>
            	 	&nbsp
           		 	 <%}%>
             <a href="?logout=true"> logout</a>
			 </div>
			 <%}} %>
        </div>
    </div>
</nav>