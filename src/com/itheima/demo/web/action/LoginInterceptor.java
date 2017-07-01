package com.itheima.demo.web.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class LoginInterceptor extends MethodFilterInterceptor {

	//重写
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断是否等陆，即查找session是否有需要的元素
		if(null==ServletActionContext.getRequest().getSession().getAttribute("loginUser")){
			ActionSupport action = (ActionSupport) invocation.getAction();
			action.addActionError("请先登录");
			return Action.LOGIN;
		}
		//放行
		return invocation.invoke();
	}

}
