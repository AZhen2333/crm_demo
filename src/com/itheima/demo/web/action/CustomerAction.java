package com.itheima.demo.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.itheima.demo.domain.Customer;
import com.itheima.demo.page.Pagination;
import com.itheima.demo.service.CustomerService;
import com.itheima.demo.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	Customer customer = new Customer();

	@Override
	public Customer getModel() {
		return customer;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public String showAdd() {
		return "addjsp";
	}

	// 在值栈中，放入指定属性即可
	private File upload;// 上传的文件对象<s:file name="upload"/>,临时目录下的
	private String uploadContentType;// 文件类型，必须满足name+ContentType
	private String uploadFileName;// 文件名字，必须满足name+FileName

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	// 添加
	public String saveCustomer() throws Exception {
		if (upload != null) {

			// 生成随机的文件名
			String randonFileName = UploadUtils.generateRandonFileName(uploadFileName);
			// 生成随机的的文件夹
			String randomDir = UploadUtils.generateRandomDir(randonFileName);
			// 目标文件的相对路径
			String filePath = randomDir + "/" + randonFileName;
			// 目标文件的绝对路径
			// String destFilePath="E:/crm_test"+filePath;
			String destFilePath = SystemContant.FILE_UPLOAD_BASE_PATH + filePath;
			// 复制文件
			FileUtils.copyFile(upload, new File(destFilePath));

			// 赋值
			customer.setCust_filename(uploadFileName);
			customer.setCust_path(filePath);
		}
		customerService.saveCustomer(customer);
		return "listPageAction";
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

	// 分页查询
	public String listPage() {
		Pagination<Customer> pagination = new Pagination<Customer>();
		// 分页的条件查询
		// 存放所有的数据在集合中
		Map<String, String[]> parameterMap = ServletActionContext.getRequest().getParameterMap();
		// 封装数据
		pagination.setParameterMap(parameterMap);

		// 当前页码
		if (page > 0) {
			pagination.setPage(page);
		}
		// 显示的最大记录数
		if (pageSize > 0) {
			pagination.setPageSize(pageSize);
		}
		// 查询
		customerService.findCustomerListPage(pagination);
		// 返回结果，放进栈中
		ActionContext.getContext().put("pagination", pagination);
		// 回显
		return "listjsp";
	}

	// 删除
	public String delete() {
		// 先查
		Customer queryCustomer = customerService.findCustomerByID(customer.getCust_id());
		// 删除文件
		// 文件相对路径
		String cust_path = queryCustomer.getCust_path();
		// 文件绝对路径
		String destFilePath = SystemContant.FILE_UPLOAD_BASE_PATH + "/" + cust_path;
		// 删除
		new File(destFilePath).delete();

		// 持久太删除客户信息
		customerService.deleteCustomerByID(queryCustomer);

		return "listPageAction";
	}

	// 回显修改数据
	public String showEdit() {
		Customer queryCustomer = customerService.findCustomerByID(customer.getCust_id());
		ActionContext.getContext().getValueStack().push(queryCustomer);
		return "editjsp";
	}

	// 修改数据
	@InputConfig(resultName = "editinput") // 更改遇到错误默认的跳转页面
	public String edit() throws Exception {
		// 文件
		// 1)保存新文件
		// 1.临时保存旧文件的路径
		String oldFilePath = SystemContant.FILE_UPLOAD_BASE_PATH + customer.getCust_path();
		// 2.生成新的文件名和文件夹
		String newRandonFileName = UploadUtils.generateRandonFileName(uploadFileName);
		String newRandonDir = UploadUtils.generateRandomDir(newRandonFileName);
		// 3.目标文件的相对路径
		String filePath = newRandonDir + "/" + newRandonFileName;
		// 3.目标文件的绝对路径
		String destFilePath = SystemContant.FILE_UPLOAD_BASE_PATH + filePath;
		// 封装
		customer.setCust_filename(newRandonFileName);
		customer.setCust_path(filePath);
		// 文件复制
		FileUtils.copyFile(upload, new File(destFilePath));
		// 2)删除旧文件
		new File(oldFilePath).delete();
		// 修改数据
		customerService.updateCustomer(customer);
		return "listPageAction";
	}

	// 查询所有客户,异步
	public String findAll() throws Exception {
		List<Customer> customerList = customerService.findCustomerList();
		//转json
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"linkManSet","baseDictSource","baseDictIndustry","baseDictLevel"});
		JSONArray jsonArray = JSONArray.fromObject(customerList,jsonConfig);
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().print(jsonArray.toString());
		return NONE;
	}
	

}
