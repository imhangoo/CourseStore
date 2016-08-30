package com.imhangoo.coursestore.model;

public class Course {
	private int id;
	private String name;
	private int category;
	private float price;
	private String pic;
	private String desc;
	
	
	public Course() {
	}
	
	public Course(int id){
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}


	public String getPic() {
		return pic;
	}


	public void setPic(String pic) {
		this.pic = pic;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}



	

}
