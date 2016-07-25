package com.imhangoo.coursestore.model;

public class CartItem {
	private int courseID;
	private int quantity;
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public CartItem(int courseID, int quantity) {
		super();
		this.courseID = courseID;
		this.quantity = quantity;
	}
	
	public void add(int i){
		quantity+=i;
	}
	
	

}
