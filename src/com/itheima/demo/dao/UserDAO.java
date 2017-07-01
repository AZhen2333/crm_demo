package com.itheima.demo.dao;

import java.util.List;

import com.itheima.demo.domain.User;

public interface UserDAO {

	public User loginUser(String user_code, String user_password);

	public List<User> findUserList();

}
