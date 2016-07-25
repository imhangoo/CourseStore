package com.imhangoo.coursestore.DAO;

import java.util.List;

import com.imhangoo.coursestore.model.Category;

public interface CategoryDAO {
	public void save(Category c);
	public List<Category> getCategoryList();
	public void delete(int id);


}
