package com.itheima.demo.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.demo.dao.LinkManDAO;
import com.itheima.demo.domain.LinkMan;

public class LinkManDAOImpl extends HibernateDaoSupport implements LinkManDAO {

	//总页数
		@Override
		public Long findCount(DetachedCriteria criteria) {
			criteria.setProjection(Projections.rowCount());
			List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(criteria);
			return list.isEmpty()?null:list.get(0);
		}

	// 每页的数据
	@Override
	public List<LinkMan> findResultList(DetachedCriteria criteria, int firstResult, int maxResults) {
		criteria.setProjection(null);
		return (List<LinkMan>) getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
	}

	@Override
	public LinkMan findLinkManByID(Long lkm_id) {
		return getHibernateTemplate().get(LinkMan.class, lkm_id);
	}

	@Override
	public void updateLinkMan(LinkMan linkMan) {
		getHibernateTemplate().update(linkMan);
		
	}

	@Override
	public void deleteLinkMan(LinkMan linkMan) {
		getHibernateTemplate().delete(linkMan);
	}

}
