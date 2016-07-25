<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%
CourseManager courseManager = CourseManager.getInstance();
List<Course> courseList = courseManager.getCourseList();
%>

<div class="jumbotron">
    <div class="container">
        <h1>Welcome!</h1>
        <p>A course store for programmers, we have a lot of hot courses. Choose your favorite ones, and improve yourself. </p>
        <p>Test user account: imhangoo,8395</p>
        <p>Test admin account: admin,admin</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
    </div>
</div>

<!-- Recently Added -->

<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>Recently Added <span class="label label-success">New</span></h1>
        </div>
        <%for(int i = 0; i< 3; i++){ %>
        <div class="col-xs-6 col-md-4">
            <h2><%=courseList.get(i).getName() %></h2>
            <a href="courseDetail.jsp?id=1" class="thumbnail">
                <img src="img/panda.jpg" alt="pada">
            </a>
            <p><a href="addToCart.jsp?id=<%=courseList.get(i).getId() %>" class="btn btn-default btn-lg" role="button">Add to cart</a></p>
        </div>
		<%} %>

    </div>

    <br/>

<!-- Most Popular -->
    <div class="row">
        <div class="page-header">
            <h1>Most Popular</h1>
          
         </div>
        <%for(int i = 0; i< 3; i++){ %>
        <div class="col-xs-6 col-md-4">
            <h2><%=courseList.get(i).getName() %></h2>
            <a href="courseDetail.jsp?id=1" class="thumbnail">
                <img src="img/panda.jpg" alt="pada">
            </a>
            <p><a href="addToCart.jsp?id=<%=courseList.get(i).getId() %>" class="btn btn-default btn-lg" role="button">Add to cart</a></p>
        </div>
		<%} %>

    </div>

</div>

</body>
</html>