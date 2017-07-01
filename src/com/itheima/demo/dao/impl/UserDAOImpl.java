package com.itheima.demo.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.demo.dao.UserDAO;
import com.itheima.demo.domain.User;

public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {

	@Override
	public User loginUser(String user_code, String user_password) {
		DetachedCriteria criteria=DetachedCriteria.forClass(User.class);
		criteria.add(Restrictions.eq("user_code",user_code));
		criteria.add(Restrictions.eq("user_password",user_password));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(criteria);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public List<User> findUserList() {
		return getHibernateTemplate().loadAll(User.class);
	}

}
