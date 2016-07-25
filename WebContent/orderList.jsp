<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%
 %>
<div class="cart-list container">
	<h2>My Orders</h2>
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
    <%for(int i = 0; i< 10; i++){ %>
      <tr>
        <td>Java for beginners</td>
        <td>1</td>
        <td>1</td>
        <td>1</td>
        <td>DELETE</td>
      </tr>
      <% }%>
      <tr><td id="total" colspan="5">Total: $35.6 </td></tr>
      <tr><td colspan="5"><a href="cartList.jsp" class="cart-submit btn btn-md btn-warning">Checkout</a></td></td></tr>
    </tbody>
  </table>
	
</div>

</body>

</html>