package com.itheima.demo.service;

import java.util.List;

import com.itheima.demo.domain.User;

public interface UserService {


	public User loginUser(String user_code, String user_password);

	public List<User> findUserList();

}
