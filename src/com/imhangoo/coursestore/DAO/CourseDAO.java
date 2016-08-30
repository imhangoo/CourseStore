package com.imhangoo.coursestore.DAO;

import java.util.List;

import com.imhangoo.coursestore.model.Course;

public interface CourseDAO {
	public void save(Course course);
	public List<Course> getCourseList();
	public void delete(int id);
	public Course getCourseById(int id);

}
