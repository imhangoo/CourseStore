package com.imhangoo.coursestore.service;

import java.util.List;

import com.imhangoo.coursestore.DAO.CategoryDAO;
import com.imhangoo.coursestore.DAO.impl.MysqlCategoryDAO;
import com.imhangoo.coursestore.model.Category;

public class CategoryManager {
	public static CategoryManager categoryManager = null;
	private CategoryDAO dao = null;
	List<Category> categoryList = null;
	
	private CategoryManager(){
		dao = MysqlCategoryDAO.getInstance();
	}
	
	// Singleton
	public static CategoryManager getInstance(){
		if(categoryManager==null){
			categoryManager = new CategoryManager();
		}
		return categoryManager;
	}
	
	public void save(int id, String name){
		Category c = new Category(id,name);
		dao.save(c);
	}
	
	
	public List<Category> getCategoryList(){
		categoryList = dao.getCategoryList();
		return categoryList;
	}
	
	public void delete(int id){
		dao.delete(id);
	}


}
