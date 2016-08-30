package com.imhangoo.coursestore.model;

import com.imhangoo.coursestore.service.CourseManager;

public class CartItem {
	private Course course;
	private int quantity;
	
	public CartItem(int courseId, int qty){
		CourseManager courseManager = CourseManager.getInstance();
		course = courseManager.getCourseById(courseId);
		quantity = qty;
		
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void add(int qty){
		quantity+=qty;
	}

	
	
	
	

}
