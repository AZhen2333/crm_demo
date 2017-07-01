package com.itheima.demo.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.demo.dao.CustomerDAO;
import com.itheima.demo.domain.Customer;
import com.itheima.demo.domain.LinkMan;

public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO {

	@Override
	public void saveCustomer(Customer customer) {
		getHibernateTemplate().save(customer);
	}

	// 总页数
	@Override
	public Long findCount(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return list.isEmpty() ? 0 : list.get(0);
	}

	// 每页显示的数据
	@Override
	public List<Customer> findResultList(DetachedCriteria criteria, int firstResult, int maxResults) {
		criteria.setProjection(null);
		return (List<Customer>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);

	}

	@Override
	public void deleteCustomerByID(Customer customer) {
		getHibernateTemplate().delete(customer);

	}

	@Override
	public Customer findCustomerByID(Long cust_id) {
		return getHibernateTemplate().get(Customer.class, cust_id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		getHibernateTemplate().update(customer);

	}

	@Override
	public List<Customer> findAll() {
		return getHibernateTemplate().loadAll(Customer.class);
	}

	@Override
	public void saveLinkMan(LinkMan linkMan) {
		getHibernateTemplate().save(linkMan);
	}

}
