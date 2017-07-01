package com.itheima.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.demo.domain.Customer;
import com.itheima.demo.domain.LinkMan;

public interface CustomerDAO {

	public void saveCustomer(Customer customer);

	public Long findCount(DetachedCriteria criteria);

	public List<Customer> findResultList(DetachedCriteria criteria, int firstResult, int maxResults);

	public void deleteCustomerByID(Customer customer);

	public Customer findCustomerByID(Long cust_id);

	public void updateCustomer(Customer customer);

	public List<Customer> findAll();

	public void saveLinkMan(LinkMan linkMan);

}
