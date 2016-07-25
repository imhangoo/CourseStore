<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container">
  <h2>Order Management</h2>
  <p>Modify or delete orders.</p>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Order ID</th>
        <th>Customer ID</th>
        <th>Purchase Date</th>
        <th>Detail</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    
      <tr>
        <td>1</td>
        <td>12</td>
        <td>2016-07-17</td>
        <td><a href="orderDetail.jsp?id=1" class="btn btn-xs btn-success">Detail</a></td>
        <td><a onclick="return confirm('Really want to delete the order?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
      <tr>
        <td>2</td>
        <td>133</td>
        <td>2016-07-16</td>
        <td><a href="orderDetail.jsp?id=1" class="btn btn-xs btn-success">Detail</a></td>
        <td><a onclick="return confirm('Really want to delete the order?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
      <tr>
        <td>3</td>
        <td>122</td>
        <td>2016-07-14</td>
        <td><a href="orderDetail.jsp?id=1" class="btn btn-xs btn-success">Detail</a></td>
        <td><a onclick="return confirm('Really want to delete the order?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>