<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%
OrderManager orderManager = OrderManager.getInstance();
List<Order> orders = orderManager.getOrdersByUserId(4);

 %>
<div class="cart-list container">
	<h2>My Orders</h2>
	<%
	for(Order order:orders){ 
	float total = 0;      
	%>
	<h4>Order Id: <%=order.getId() %></h4>
	<h4>Order Time: <%=order.getDate() %></h4>
	<table class="table table-bordered table-hover">
    <thead>
      <tr>
        <th>Course</th>
        <th>Unit Price</th>
        <th>Quantity</th>
        <th>Sub Total</th>
      </tr>
    </thead>
    <tbody>
    <%for(OrderItem item:order.getItems()){ 
    float unitPrice = item.getCourse().getPrice();
    int qty = item.getQuantity();
    float subTotal = unitPrice * qty;
    %>
      <tr>
        <td><%=item.getCourse().getName() %></td>
        <td><%=unitPrice %></td>
        <td><%=qty %></td>
        <td><%=subTotal %></td>
      </tr>
      <% total += subTotal;}%>
      <tr><td id="total" colspan="5">Total: <%=total %> </td></tr>
    </tbody>
  </table>
	<%} %>
</div>

</body>

</html>