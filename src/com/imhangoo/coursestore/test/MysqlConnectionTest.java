package com.imhangoo.coursestore.test;

import org.junit.Before;
import org.junit.Test;

import com.imhangoo.coursestore.DAO.impl.MysqlUserDAO;
import com.imhangoo.coursestore.model.User;

public class MysqlConnectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		 MysqlUserDAO dao = MysqlUserDAO.getInstance();
		 User user = new User("hangoo","oooo","");
		 dao.save(user);
	}

}
