package com.imhangoo.coursestore.DAO;

import java.util.List;

import com.imhangoo.coursestore.model.User;

public interface UserDAO {
	public void save(User user);

	public boolean validate(User user);

	public List<User> getUserList();

	public void delete(int id);


}
