package com.itheima.demo.web.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.itheima.demo.domain.SaleVisit;
import com.itheima.demo.page.Pagination;
import com.itheima.demo.service.SaleVisitService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {

	private SaleVisit saleVisit=new SaleVisit();
	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	
	//注入
	private SaleVisitService saleVisitService;
	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}
	
	//属性驱动，获取当前页和每页显示条数
	private int page;
	private int pageSize;
	
	public void setSaleVisit(SaleVisit saleVisit) {
		this.saleVisit = saleVisit;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	//客户拜访分页列表
	public String listPage(){
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		//构建bean
		Pagination<SaleVisit> pagination=new Pagination<SaleVisit>();
		pagination.setParameterMap(parameterMap);
		//封装当前页和每页条数
		if(page>0){
			pagination.setPage(page);
		}
		if(pageSize>0){
			pagination.setPageSize(pageSize);
		}
		//分页查询
		saleVisitService.findSaleVisitListPage(pagination);
		System.out.println(pagination.toString());
		ActionContext.getContext().put("pagination",pagination);
		return "listjsp";
	}

	public String add(){
		return "addjsp";
	}
	
	public String save(){
		saleVisitService.saveSaleVisit(saleVisit);
		return "listPageAction";
	}
}
