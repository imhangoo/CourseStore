package com.imhangoo.coursestore.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.imhangoo.coursestore.DAO.impl.MysqlOrderDAO;
import com.imhangoo.coursestore.model.Order;
import com.imhangoo.coursestore.model.OrderItem;

public class MysqlConnectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		 MysqlOrderDAO dao = MysqlOrderDAO.getInstance();
		 List<Order> orders = dao.getOrdersByUserId(4);
		 for(Order order: orders){
			 for(OrderItem item:order.getItems()){
				 System.out.println(item.getCourse().getName());
			 }
		 }
	}

}
