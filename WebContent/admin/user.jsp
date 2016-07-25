<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.imhangoo.coursestore.model.*,com.imhangoo.coursestore.service.*,
				java.util.*,java.text.*" %>  
				  
<jsp:include page="header.jsp"></jsp:include>

<%
UserManager userManager = UserManager.getInstance();
List<User> userList = userManager.getUserList();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
%>
<body>
<div class="container">
  <h2>User List</h2>
  <p>List names and registration dates of all users.</p>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Account Name</th>
        <th>Email</th>
        <th>Register Time</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    <%for(User user:userList){%>
      <tr>
        <td><%=user.getName() %></td>
        <td><%=user.getEmail() %></td>
        <td><%=formatter.format(user.getDate()) %></td>
        <td><a href="userDelete.jsp?id=<%=user.getId()%>" onclick="return confirm('Really want to delete the user?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
      <%} %>
    </tbody>
  </table>
</div>
</body>
</html>