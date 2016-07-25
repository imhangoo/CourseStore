package com.imhangoo.coursestore.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> cart;

	public Cart() {
		cart = new ArrayList<CartItem>();
	}

	public List<CartItem> getCart() {
		return cart;
	}

	public void setCart(List<CartItem> cart) {
		this.cart = cart;
	}
	
	public int getSize(){
		return cart.size();
	}
	
	public void add(CartItem item){
		for(CartItem i:cart){
			if(item.getCourseID()==i.getCourseID()){
				i.add(item.getQuantity());
				return;
			}
		}
		cart.add(item);
	}
	
	public void checkout(){
		
	}
	

}
