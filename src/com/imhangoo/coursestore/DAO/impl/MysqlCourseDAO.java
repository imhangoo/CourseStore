package com.imhangoo.coursestore.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imhangoo.coursestore.DAO.CourseDAO;
import com.imhangoo.coursestore.model.Course;

public class MysqlCourseDAO extends MysqlUtil implements CourseDAO{
	public static MysqlCourseDAO dao = null;

	public void save(Course course) {
		Connection conn = getConnection();
		String sql = "INSERT INTO Course VALUES (null,?,?,?)";
		PreparedStatement pstmt = getPstmt(conn, sql);
		try {
			pstmt.setString(1, course.getName());
			pstmt.setInt(2, course.getCategory());
			pstmt.setFloat(3, course.getPrice());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

	}

	public List<Course> getCourseList() {
		List<Course> courseList = new ArrayList<Course>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM Course";
		PreparedStatement pstmt = getPstmt(conn, sql);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int category = rs.getInt("category");
				float price = rs.getFloat("price");
				Course c = new Course();
				c.setId(id);
				c.setName(name);
				c.setCategory(category);
				c.setPrice(price);
				courseList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return courseList;
	}

	// Singleton
	public static MysqlCourseDAO getInstance() {
		if (dao == null) {
			dao = new MysqlCourseDAO();
		}
		return dao;
	}
	
	public void delete(int id) {
		Connection conn = getConnection();
		String sql = "DELETE FROM course WHERE id = ?";
		PreparedStatement pstmt = getPstmt(conn, sql);
		try {
			pstmt.setInt(1,id);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(conn);
		}
	}
}
