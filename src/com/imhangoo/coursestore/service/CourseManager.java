package com.imhangoo.coursestore.service;

import java.util.List;

import com.imhangoo.coursestore.DAO.CourseDAO;
import com.imhangoo.coursestore.DAO.impl.MysqlCourseDAO;
import com.imhangoo.coursestore.model.Course;

public class CourseManager {
	public static CourseManager courseManager = null;
	private CourseDAO dao = null;
	List<Course> courseList = null;
	
	private CourseManager(){
		dao = MysqlCourseDAO.getInstance();
	}
	
	// Singleton
	public static CourseManager getInstance(){
		if(courseManager==null){
			courseManager = new CourseManager();
		}
		return courseManager;
	}
	
	public void save(int id, String name, int category, float price){
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setCategory(category);
		course.setPrice(price);
		dao.save(course);
	}
	
	
	public List<Course> getCourseList(){
		courseList = dao.getCourseList();
		return courseList;
	}
	
	public void delete(int id){
		dao.delete(id);
	}
	
	public Course getCourseById(int id){
		return dao.getCourseById(id);
	}

}
