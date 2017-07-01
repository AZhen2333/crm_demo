package com.itheima.demo.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.itheima.demo.domain.User;
import com.itheima.demo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	User user = new User();

	@Override
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String login() throws IOException{
		User loginUser=userService.loginUser(user.getUser_code(),user.getUser_password());
		System.out.println(user.getUser_code()+user.getUser_password());
		if(loginUser==null){
			ServletActionContext.getResponse().getWriter().println("帐号或密码错误");
			return LOGIN;
		}else{
			ServletActionContext.getRequest().getSession().setAttribute("loginUser", loginUser);
			return SUCCESS;
		}
	}
	
	public String findAll() throws Exception{
		List<User> userList= userService.findUserList();
		//转json
		JSONArray jsonArray = JSONArray.fromObject(userList);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return NONE;
	}

}
