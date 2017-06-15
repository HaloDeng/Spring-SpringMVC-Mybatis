package com.halo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.halo.entity.User;
import com.halo.service.UserService;
import com.halo.utils.GenerateUUID;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/userInfo.do")
	public String userInfo(User user){
		//user.setUserId(1);
		User u = userService.getUser(user);
		//返回视图名
		return "UserList";
	}
	
	@RequestMapping(value="/userInfoByName.do")
	public String userInfoByName(User user){
		user.setUserName("halo");
		User u = userService.getUser(user);
		
		//返回视图名
		return "UserList";
	}

	@RequestMapping(value="/addUser.do")
	public String addUser(User user){
		user.setUserId(GenerateUUID.getUUID());
		user.setUserName("admin");
		user.setPassword("halo");
		user.setPhoneNum("13517190241");
		user.setEmail("hailuo4583.deng@gmail.com");
		userService.addUser(user);
		System.out.println(user.getUserId());
		return "UserList";
	}
	
	@RequestMapping(value="/addUserForTx.do")
	public String addUserForTx(User user){
		user.setUserId(GenerateUUID.getUUID());
		user.setUserName("admin");
		user.setPassword("halo");
		user.setPhoneNum("13517190241");
		user.setEmail("hailuo4583.deng@gmail.com");
		userService.addUserForTx(user);
		System.out.println(user.getUserId());
		return "UserList";
	}

	

}
