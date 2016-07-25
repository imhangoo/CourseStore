<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.imhangoo.coursestore.model.Category,com.imhangoo.coursestore.service.CategoryManager" %>
<jsp:include page="header.jsp"></jsp:include>

<%
CategoryManager categoryManager = CategoryManager.getInstance();
List<Category> categoryList = categoryManager.getCategoryList();
%>

<body>
<div class="container">
  <h2>Category Management</h2>
  <p>Modify or delete categories.</p>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    <%for(Category category:categoryList){%>
      <tr>
        <td><%=category.getId() %></td>
        <td><%=category.getName() %></td>
        <td><a href="categoryDelete.jsp?id=<%=category.getId()%>" onclick="return confirm('Really want to delete the category?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
      <%} %>
    </tbody>
  </table>
</div>
</body>
</html>