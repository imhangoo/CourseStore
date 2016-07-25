package com.imhangoo.coursestore.model;

import java.util.Date;

public class User {
	private int id;
	private String name;
	private String password;
	private String email;
	private Date date;
	
    public User(){
    	
    }
	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
		this.date = new Date();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
