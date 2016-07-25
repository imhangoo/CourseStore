<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="session_check.jsp"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<ul>
  <li><a href="../index.jsp">Return Home</a></li>
  <li><a class="active" href="statistics.jsp" target="main-frame">Statistic</a></li>
  <li><a href="user.jsp" target="main-frame">Users</a></li>
  <li><a href="category.jsp" target="main-frame">Categories</a></li>
  <li><a href="course.jsp" target="main-frame">Courses</a></li>
  <li><a href="orderHeader.jsp" target="main-frame">Orders</a></li>
</ul>

<iframe src="statistics.jsp" class="main-frame" name="main-frame">
  <h2>Fixed Full-height Side Nav</h2>
  <h3>Try to scroll this area, and see how the sidenav sticks to the page</h3>
  <p>Notice that this div element has a left margin of 25%. This is because the side navigation is set to 25% width. If you remove the margin, the sidenav will overlay/sit on top of this div.</p>
  <p>Also notice that we have set overflow:auto to sidenav. This will add a scrollbar when the sidenav is too long (for example if it has over 50 links inside of it).</p>
  <p>Some text..</p>
  <p>Some text..</p>
  <p>Some text..</p>
  <p>Some text..</p>
  <p>Some text..</p>
  <p>Some text..</p>
  <p>Some text..</p>
</iframe>

</body>
</html>