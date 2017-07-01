package com.itheima.demo.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.demo.dao.BaseDictDAO;
import com.itheima.demo.domain.BaseDict;

public class BaseDictDAOImpl extends HibernateDaoSupport implements BaseDictDAO {

	@Override
	public List<BaseDict> findSourceByTypeCode(String dict_type_code) {
		DetachedCriteria criteria=DetachedCriteria.forClass(BaseDict.class);
		criteria.add(Restrictions.eq("dict_type_code", dict_type_code));
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(criteria);
		System.out.println(list.toString());
		return list ;
	}

}
