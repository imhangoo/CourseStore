<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ include file="session_check.jsp" %>
<%@ page import="java.util.*,com.imhangoo.coursestore.model.Course,com.imhangoo.coursestore.service.CourseManager" %>
<jsp:include page="header.jsp"></jsp:include>
<%
CourseManager courseManager = CourseManager.getInstance();
List<Course> courseList = courseManager.getCourseList();
%>

<body>
<div class="container">
  <h2>Course Management</h2>
  <p>Modify or delete categories.</p>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    <%for(Course course:courseList){%>
      <tr>
        <td><%=course.getId() %></td>
        <td><%=course.getName() %></td>
        <td><%=course.getCategory() %></td>
        <td><%=course.getPrice() %></td>
        <td><a href="courseDelete.jsp?id=<%=course.getId() %>" onclick="return confirm('Really want to delete the course?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
      <%} %>
    </tbody>
  </table>
</div>
</body>
</html>