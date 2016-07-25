package com.imhangoo.coursestore.service;

import java.util.List;

import com.imhangoo.coursestore.DAO.UserDAO;
import com.imhangoo.coursestore.DAO.impl.MysqlUserDAO;
import com.imhangoo.coursestore.model.User;

public class UserManager {
	public static UserManager userManager = null;
	private UserDAO dao = null;
	List<User> userList = null;
	
	private UserManager(){
		dao = MysqlUserDAO.getInstance();
	}
	
	// Singleton
	public static UserManager getInstance(){
		if(userManager==null){
			userManager = new UserManager();
		}
		return userManager;
	}
	
	public void save(String name, String password,String email){
		User user = new User(name,password,email);
		dao.save(user);
	}
	
	public User validate(String name, String password){
		User user = new User(name,password,null);
		if(dao.validate(user)){
			return user;
		}else{
			return null;
		}
	}
	
	public List<User> getUserList(){
		userList = dao.getUserList();
		return userList;
	}
	
	public void delete(int id){
		dao.delete(id);
	}

}
