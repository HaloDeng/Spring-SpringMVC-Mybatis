package com.halo.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.halo.dao.UserDAO;
import com.halo.entity.User;
import com.halo.utils.MD5Utils;

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
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void addUserForTx(User user){
	
		String s = MD5Utils.to16LowerMD5("ssssssssss");
		
		userDao.addOne(user);
		
	}
	
	public User getUser(User user){
		return userDao.getUserById(user);
	}
	
	public User getUserByName(User user){
		return userDao.getUserByName(user.getUserName());
	}
	

}
