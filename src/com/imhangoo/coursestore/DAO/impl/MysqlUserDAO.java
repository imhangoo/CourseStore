package com.imhangoo.coursestore.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imhangoo.coursestore.DAO.UserDAO;
import com.imhangoo.coursestore.model.User;

public class MysqlUserDAO extends MysqlUtil implements UserDAO {

	private static MysqlUserDAO dao;

	private MysqlUserDAO() {

	}

	public void save(User user) {
		Connection conn = getConnection();
		String sql = "INSERT INTO user VALUES (null,?,?,?,?)";
		PreparedStatement pstmt = getPstmt(conn, sql);
		try {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setTimestamp(4, new Timestamp(user.getDate().getTime()));
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(pstmt);
			close(conn);
		}
		

	}

	// Singleton
	public static MysqlUserDAO getInstance() {
		if (dao == null) {
			dao = new MysqlUserDAO();
		}
		return dao;
	}

	@Override
	public boolean validate(User user) {
		Connection conn = getConnection();
		String sql = "SELECT * FROM user where name=? and password=?";
		PreparedStatement pstmt = getPstmt(conn, sql);
		ResultSet rs = null;
		boolean isValid = false;
		try {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()){
				isValid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(conn);
		}
		
		return isValid;
		
	}

	@Override
	public List<User> getUserList() {
		List<User> userList = new ArrayList<User>();
		Connection conn = getConnection();
		String sql = "SELECT * FROM user";
		PreparedStatement pstmt = getPstmt(conn, sql);
		ResultSet rs = null;
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date date = new Date(rs.getTimestamp("rdate").getTime());
				User user = new User();
				user.setId(id);
				user.setName(name);
				user.setEmail(email);
				user.setDate(date);
				userList.add(user);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(conn);
		}
		return userList;
		
	}

	public void delete(int id) {
		Connection conn = getConnection();
		String sql = "DELETE FROM user WHERE id = ?";
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
