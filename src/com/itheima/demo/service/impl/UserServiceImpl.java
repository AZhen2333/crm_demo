package com.itheima.demo.service.impl;

import java.util.List;

import com.itheima.demo.dao.UserDAO;
import com.itheima.demo.domain.User;
import com.itheima.demo.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User loginUser(String user_code, String user_password) {
		return userDAO.loginUser(user_code,user_password);
	
	}

	@Override
	public List<User> findUserList() {
		return userDAO.findUserList();
	}


}
