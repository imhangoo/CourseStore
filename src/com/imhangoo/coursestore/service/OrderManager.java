package com.imhangoo.coursestore.service;

import java.util.ArrayList;
import java.util.List;

import com.imhangoo.coursestore.model.Cart;
import com.imhangoo.coursestore.model.CartItem;
import com.imhangoo.coursestore.model.OrderDetail;
import com.imhangoo.coursestore.model.OrderHeader;

public class OrderManager {
	public OrderHeader cartToOrder(Cart cart){
		OrderHeader oh = new OrderHeader();
		List<CartItem> itemLists = cart.getCart();
		List<OrderDetail> details = new ArrayList<OrderDetail>();
		for(CartItem item:itemLists){
			OrderDetail detail = new OrderDetail();
			detail.setCourseID(item.getCourseID());
			detail.setQuantity(item.getQuantity());
			details.add(detail);
		}
		oh.setDetails(details);
		return oh;
	}
	
	public void save(){
		
	}

}
