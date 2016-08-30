package com.imhangoo.coursestore.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items;
	
	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public Cart() {
		items = new ArrayList<CartItem>();
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setCart(List<CartItem> cart) {
		this.items = cart;
	}
	
	public int getSize(){
		return items.size();
	}
	
	public void add(CartItem item){
		for(CartItem i:items){
			if(item.getCourse().getId()==i.getCourse().getId()){
				i.add(item.getQuantity());
				return;
			}
		}
		items.add(item);
	}
	
	public void checkout(){
		
	}
	

}
