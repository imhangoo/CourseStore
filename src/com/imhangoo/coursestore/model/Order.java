package com.imhangoo.coursestore.model;

import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private int customerID;
	private Date date;
	private List<OrderItem> items;
	
	public Order(){
		date = new Date();
		
	}
	
	public Order(int id){
		this.id = id;
		date = new Date();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	
	
	
	

}
