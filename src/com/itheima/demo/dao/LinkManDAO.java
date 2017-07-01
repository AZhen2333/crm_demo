package com.itheima.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.demo.domain.Customer;
import com.itheima.demo.domain.LinkMan;

public interface LinkManDAO {

	public Long findCount(DetachedCriteria criteria);

	public List<LinkMan> findResultList(DetachedCriteria criteria, int firstResult, int maxResults);

	public LinkMan findLinkManByID(Long lkm_id);

	public void updateLinkMan(LinkMan linkMan);

	public void deleteLinkMan(LinkMan linkMan);






}
