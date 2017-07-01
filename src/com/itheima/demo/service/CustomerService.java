package com.itheima.demo.service;

import java.util.List;

import com.itheima.demo.domain.Customer;
import com.itheima.demo.domain.LinkMan;
import com.itheima.demo.page.Pagination;

public interface CustomerService {

	public void saveCustomer(Customer customer);


	public void findCustomerListPage(Pagination<Customer> pagination);


	public void deleteCustomerByID(Customer customer);


	public Customer findCustomerByID(Long cust_id);


	public void updateCustomer(Customer customer);


	public List<Customer> findCustomerList();


	public void saveLinkMan(LinkMan linkMan);

}
