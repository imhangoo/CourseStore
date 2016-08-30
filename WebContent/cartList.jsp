<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@include file="header.jsp"%>
<%
if(cart==null){
	response.sendRedirect("index.jsp");
	return;
}
%>
<!-- check if logged in before checkout -->
<script>
function beforeCheckout(){
	var k = "<%=user%>";
	if(k == "null"){
		alert("Please login before checkout");
		return false;
	}
	return confirm("Are you ready to make a payment?");
	
}

</script>
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
    <% 
    float total = 0;
    for(int i = 0; i< cart.getSize(); i++){ 
        String name = cart.getItems().get(i).getCourse().getName();
        float price = cart.getItems().get(i).getCourse().getPrice();
        int qty = cart.getItems().get(i).getQuantity();
        float subTotal = price * qty;
        total += subTotal;
    %>
    	
      <tr>
        <td><%=name %></td>
        <td>$<%=price %></td>
        <td><%=qty %></td>
        <td>$<%=subTotal%></td>
        <td>DELETE</td>
      </tr>
      <% }%>
      <tr><td id="total" colspan="5">Total: $<%=total%> </td></tr>
      <tr><td colspan="5"><a onclick="return beforeCheckout()" href="checkout" class="cart-submit btn btn-md btn-warning">Checkout</a></td></td></tr>
    </tbody>
  </table>
	
</div>

</body>

</html>