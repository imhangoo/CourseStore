<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%
if(cart==null){
	response.sendRedirect("index.jsp");
	return;
}
%>
<div class="cart-list container">
	<h2>My Cart List</h2>
	<table class="table table-bordered table-hover">
    <thead>
      <tr>
        <th>Course</th>
        <th>Unit Price</th>
        <th>Quantity</th>
        <th>Sub Total</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    <%for(int i = 0; i< cart.getSize(); i++){ %>
      <tr>
        <td><%=cart.getCart().get(i).getCourseID() %></td>
        <td>35</td>
        <td><%=cart.getCart().get(i).getQuantity() %></td>
        <td>35</td>
        <td>DELETE</td>
      </tr>
      <% }%>
      <tr><td id="total" colspan="5">Total: $35.6 </td></tr>
      <tr><td colspan="5"><a href="checkout" class="cart-submit btn btn-md btn-warning">Checkout</a></td></td></tr>
    </tbody>
  </table>
	
</div>

</body>

</html>