package com.itheima.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.itheima.demo.domain.SaleVisit;

public interface SaleVisitDAO {

	public Long findTotalPage(DetachedCriteria criteria);

	public List<SaleVisit> findResultList(DetachedCriteria criteria, int firstResult, int maxResults);

	public void save(SaleVisit saleVisit);

}
