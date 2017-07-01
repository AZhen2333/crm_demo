package com.itheima.demo.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.itheima.demo.dao.SaleVisitDAO;
import com.itheima.demo.domain.SaleVisit;

public class SaleVisitDAOImpl extends HibernateDaoSupport implements SaleVisitDAO {

	@Override
	public Long findTotalPage(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
		return list.isEmpty()?0:list.get(0);
	}

	@Override
	public List<SaleVisit> findResultList(DetachedCriteria criteria, int firstResult, int maxResults) {
		criteria.setProjection(null);
		return (List<SaleVisit>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	@Override
	public void save(SaleVisit saleVisit) {
		getHibernateTemplate().save(saleVisit);
		
	}

}
