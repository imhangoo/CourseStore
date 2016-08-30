package com.imhangoo.coursestore.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.imhangoo.coursestore.DAO.OrderDAO;
import com.imhangoo.coursestore.model.Course;
import com.imhangoo.coursestore.model.Order;
import com.imhangoo.coursestore.model.OrderItem;
import com.imhangoo.coursestore.service.CourseManager;

public class MysqlOrderDAO extends MysqlUtil implements OrderDAO{
	private static MysqlOrderDAO dao = null;

	
	public void save(Order order) {
		Connection conn = getConnection();
		String sql = null;
		PreparedStatement pstmt = null;
		List<OrderItem> items = order.getItems();
		int orderId = order.getId();
		try {
			conn.setAutoCommit(false);
			// save order header
			sql = "INSERT INTO orderHeader VALUES (?,?,?)";
			pstmt = getPstmt(conn, sql);
			pstmt.setInt(1, orderId);
			pstmt.setInt(2, order.getCustomerID());
			pstmt.setTimestamp(3, new Timestamp(order.getDate().getTime()));
			pstmt.executeUpdate();
			close(pstmt);
			
			// save order items
			sql = "INSERT INTO orderItem VALUES (?,?,?)";
			pstmt = getPstmt(conn, sql);
			for(OrderItem item : items){
				pstmt.setInt(1, orderId);
				pstmt.setInt(2, item.getCourse().getId());
				pstmt.setInt(3,item.getQuantity());
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
			
			conn.commit();
			
			
		} catch (SQLException e) {
			  try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(pstmt);
			close(conn);
		}
	}
	
	

	public int getMaxOrderId() {
		Connection conn = getConnection();
		String sql = "SELECT MAX(id) FROM orderHeader";
		PreparedStatement pstmt = getPstmt(conn, sql);
		ResultSet rs = null;
		int maxId = 0;
		try {
			rs = pstmt.executeQuery();
			if (rs.next()) {
				maxId = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			close(pstmt);
			close(conn);
		}
		return maxId;
		
	}
	
	public static MysqlOrderDAO getInstance(){
		if (dao == null) {
			dao = new MysqlOrderDAO();
		}
		return dao;
	}



	public List<Order> getOrdersByUserId(int userId) {
		Connection conn = getConnection();
		String sql = "SELECT id, orderTime FROM orderHeader WHERE customerID = ? order by id desc";
		PreparedStatement pstmt = getPstmt(conn, sql);
		ResultSet rs = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			pstmt.setInt(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Order order = new Order();
				int orderId = rs.getInt("id");
				order.setId(orderId);
				order.setCustomerID(userId);
				order.setDate(rs.getTimestamp("orderTime"));
				List<OrderItem> items = getOrderItemsByOrderId(orderId);
				order.setItems(items);
				orders.add(order);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			close(pstmt);
			close(conn);
		}
		
		return orders;
	}



	private List<OrderItem> getOrderItemsByOrderId(int orderId) {
		List<OrderItem> items = new ArrayList<OrderItem>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM orderItem WHERE orderID = ?";
		PreparedStatement pstmt = getPstmt(conn, sql);
		ResultSet rs = null;
		try {
			pstmt.setInt(1, orderId);
			rs = pstmt.executeQuery();
			while(rs.next()){
				OrderItem item = new OrderItem();
				item.setOrderID(orderId);
				item.setQuantity(rs.getInt("quantity"));
				CourseManager courseManager = CourseManager.getInstance();
				Course course = courseManager.getCourseById(rs.getInt("courseID"));
				item.setCourse(course);
				items.add(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
			close(pstmt);
			close(conn);
		}
		return items;
	}



	
}
