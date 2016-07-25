package com.imhangoo.coursestore.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlUtil {
	// get Mysql connection
	protected Connection getConnection() {
		Connection conn = null;
		String host = "localhost:3306";
		String database = "coursestore";
		String user = "imhangoo";
		String password = "8395";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection("jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password=" + password+"&useSSL=false");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}

	// get PreparedStatement
	protected PreparedStatement getPstmt(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	// close PreparedStatement
	protected void close(PreparedStatement pstmt) {

		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pstmt = null;
		}

	}

	// close Connection
	protected void close(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}

	}

	// close ResultSet
	protected void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
