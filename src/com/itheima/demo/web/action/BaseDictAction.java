package com.itheima.demo.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import com.itheima.demo.domain.BaseDict;
import com.itheima.demo.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
	BaseDict baseDict=new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}


	public String findByTypeCode() throws Exception{
		System.out.println(baseDict.toString()+baseDict.getDict_type_code());
		List<BaseDict> baseDictList=baseDictService.findSourceByTypeCode(baseDict.getDict_type_code());
		//转换成json
		JSONArray jsonArray=JSONArray.fromObject(baseDictList);
		//设置响应格式
		ServletActionContext.getResponse().setContentType("application/json;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		//异步，无回显页面
		return NONE;
	}

}
