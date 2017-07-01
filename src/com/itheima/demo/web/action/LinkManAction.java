package com.itheima.demo.web.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.itheima.demo.domain.Customer;
import com.itheima.demo.domain.LinkMan;
import com.itheima.demo.page.Pagination;
import com.itheima.demo.service.CustomerService;
import com.itheima.demo.service.LinkManService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	private LinkMan linkMan = new LinkMan();

	@Override
	public LinkMan getModel() {
		return linkMan;
	}

	// 注入Service
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	// 属性驱动
	private int page;
	private int pageSize;

	public void setPage(int page) {
		this.page = page;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	// 条件分页显示数据
	public String listPage() {
		Pagination<LinkMan> pagination = new Pagination<LinkMan>();
		// 获取所有的LinkMan相关页面参数
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		// 封装到pagination
		pagination.setParameterMap(parameterMap);
		// 当前页码
		if (page > 0) {
			pagination.setPage(page);
		}
		// 显示的最大记录数
		if (pageSize > 0) {
			pagination.setPageSize(pageSize);
		}
		System.out.println("action");
		linkManService.findLinkManListPage(pagination);
		// 压栈
		ActionContext.getContext().put("pagination", pagination);
		return "listjsp";
	}

	// 注入CustomerService
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String showAdd() {
		// 查询所属客户
		List<Customer> customerList = customerService.findCustomerList();
		// 压栈root
		ActionContext.getContext().getValueStack().set("customerList", customerList);
		return "addjsp";
	}

	// 添加客户
	public String save() {
		customerService.saveLinkMan(linkMan);
		return "listPageAction";
	}

	// 修改客户回显
	public String editShow() {
		List<Customer> customerList = customerService.findCustomerList();
		ActionContext.getContext().getValueStack().set("customerList", customerList);
		
		//根据id查询联系人
		LinkMan linkManQuery= linkManService.findLinkManByID(linkMan.getLkm_id());
		ActionContext.getContext().getValueStack().push(linkManQuery);
		return "editjsp";
	}
	
	//修改联系人
	public String edit(){
		System.out.println(linkMan.toString());
		linkManService.updateLiakMan(linkMan);
		return "listPageAction";
	} 

	//删除
	public String delete(){
		System.out.println("deleteAction");
		linkManService.deleteLinkMan(linkMan);
		return "listPageAction";
	}
}
