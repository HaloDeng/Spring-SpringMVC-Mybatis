package com.halo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.halo.dao.UserDAO;
import com.halo.entity.User;

@Transactional
@Service
public class UserService {
	@Autowired
	private UserDAO userDao;
	
	
	public User getUserInfo(User user){
		return userDao.selectOne(user);
	}
	
	public void addUser(User user){
		userDao.addOne(user);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=RuntimeException.class)
	public void addUserForTx(User user){
		userDao.addOne(user);
		throw new RuntimeException();
	}
	
	public User getUser(User user){
		return userDao.getUserById(user);
	}
	
	public User getUserByName(User user){
		return userDao.getUserByName(user);
	}
	

}
