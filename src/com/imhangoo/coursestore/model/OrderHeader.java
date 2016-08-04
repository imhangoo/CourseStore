package com.imhangoo.coursestore.model;

import java.util.Date;
import java.util.List;

public class OrderHeader {
	private int id;
	private int customerID;
	private Date date;
	private List<OrderDetail> details;
	
	
	public List<OrderDetail> getDetails() {
		return details;
	}
	public void setDetails(List<OrderDetail> details) {
		this.details = details;
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
	
	

}
