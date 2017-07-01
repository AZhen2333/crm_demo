package com.itheima.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.itheima.demo.dao.CustomerDAO;
import com.itheima.demo.domain.Customer;
import com.itheima.demo.domain.LinkMan;
import com.itheima.demo.page.Pagination;
import com.itheima.demo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}

	//分页
	@Override
	public void findCustomerListPage(Pagination<Customer> pagination) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		//条件查询
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		//客户姓名
		String cust_name=parameterMap.get("cust_name")==null?null:parameterMap.get("cust_name")[0];
		if(StringUtils.isNotBlank(cust_name)){//不为空，模糊匹配
			criteria.add(Restrictions.like("cust_name",cust_name,MatchMode.ANYWHERE));
		}
		//手机号码
		String cust_mobile=parameterMap.get("cust_mobile")==null?null:parameterMap.get("cust_mobile")[0];
		if(StringUtils.isNotBlank(cust_name)){//不为空，模糊匹配
			criteria.add(Restrictions.like("cust_mobile",cust_mobile,MatchMode.ANYWHERE));
		}
		
		
		//1.查询总条数
		Long totalCount=customerDAO.findCount(criteria);
		System.out.println("总条数"+totalCount);
		//封装结果
		pagination.setTotalCount(totalCount);
		//2.查询每页的数据
		List<Customer> resultList=customerDAO.findResultList(criteria, pagination.getFirstResult(), pagination.getMaxResults());
//		System.out.println("===="+resultList.toString());
		pagination.setResultList(resultList);
	}

	@Override
	public void deleteCustomerByID(Customer customer) {
		customerDAO.deleteCustomerByID(customer);
		
	}

	
	//根据id查找customer
	@Override
	public Customer findCustomerByID(Long cust_id) {
		return customerDAO.findCustomerByID(cust_id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
		
	}

	@Override
	public List<Customer> findCustomerList() {
		return customerDAO.findAll();
	}

	@Override
	public void saveLinkMan(LinkMan linkMan) {
		customerDAO.saveLinkMan(linkMan);
		
	}

	

	

}
