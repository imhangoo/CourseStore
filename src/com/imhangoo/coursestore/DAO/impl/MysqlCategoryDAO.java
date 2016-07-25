package com.imhangoo.coursestore.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.imhangoo.coursestore.DAO.CategoryDAO;
import com.imhangoo.coursestore.model.Category;

public class MysqlCategoryDAO extends MysqlUtil implements CategoryDAO {
	public static MysqlCategoryDAO dao = null;

	public void save(Category c) {
		Connection conn = getConnection();
		String sql = "INSERT INTO category VALUES (null,?)";
		PreparedStatement pstmt = getPstmt(conn, sql);
		try {
			pstmt.setString(1, c.getName());
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

	}

	public List<Category> getCategoryList() {
		List<Category> categoryList = new ArrayList<Category>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM category";
		PreparedStatement pstmt = getPstmt(conn, sql);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Category c = new Category();
				c.setId(id);
				c.setName(name);
				categoryList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		return categoryList;
	}

	// Singleton
	public static MysqlCategoryDAO getInstance() {
		if (dao == null) {
			dao = new MysqlCategoryDAO();
		}
		return dao;
	}

	public void delete(int id) {
		Connection conn = getConnection();
		String sql = "DELETE FROM category WHERE id = ?";
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
