package com.halo.dao;



import com.halo.entity.User;

public interface UserDAO extends IDAO<User> {
	public User getUserById(User u);
	
	public User getUserByName(String name);
	
	public void register(User user);
	
	public User login(User user);


}
