<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container">
  <h2>Detail for order vosx342345</h2>
  <p>Modify or delete order entries.</p>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Course ID</th>
        <th>Quantity</th>
        <th>Unit Price</th>
        <th>Sub total</th>
        <th>Delete</th>
      </tr>
    </thead>
    <tbody>
    
      <tr>
        <td>1</td>
        <td>12</td>
        <td>12</td>
        <td>144</td>
        <td><a onclick="return confirm('Really want to delete the order?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
      <tr>
        <td>2</td>
        <td>133</td>
        <td>2</td>
        <td>266</td>
        <td><a onclick="return confirm('Really want to delete the order?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
      <tr>
        <td>3</td>
        <td>122</td>
        <td>3</td>
        <td>366</td>
        <td><a onclick="return confirm('Really want to delete the order?')" class="btn btn-xs btn-warning">DELETE</a></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>