package com.itheima.demo.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.itheima.demo.dao.SaleVisitDAO;
import com.itheima.demo.domain.SaleVisit;
import com.itheima.demo.page.Pagination;
import com.itheima.demo.service.SaleVisitService;

public class SaleVisitServiceImpl implements SaleVisitService {

	//注入
	private SaleVisitDAO saleVisitDAO;
	public void setSaleVisitDAO(SaleVisitDAO saleVisitDAO) {
		this.saleVisitDAO = saleVisitDAO;
	}

	@Override
	public void findSaleVisitListPage(Pagination<SaleVisit> pagination) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SaleVisit.class);
		//条件查询
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		//转换日期
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		
		String visit_start_time =parameterMap.get("visit_start_time")==null?null:parameterMap.get("visit_start_time")[0];
		if(StringUtils.isNotBlank(visit_start_time)){
			try {
				criteria.add(Restrictions.ge("visit_time", df.parse(visit_start_time)));
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException("日期格式错误");
			}
		}
		String visit_end_time =parameterMap.get("visit_end_time")==null?null:parameterMap.get("visit_end_time")[0];
		if(StringUtils.isNotBlank(visit_end_time)){
			try {
				criteria.add(Restrictions.le("visit_time", df.parse(visit_end_time)));
			} catch (ParseException e) {
				e.printStackTrace();
				throw new RuntimeException("日期格式错误");
			}
		}
		//分页查询
		//总页数
		Long totalPage=saleVisitDAO.findTotalPage(criteria);
		pagination.setTotalPage(totalPage);
		//每页数据
		List<SaleVisit> resultList= saleVisitDAO.findResultList(criteria,pagination.getFirstResult(),pagination.getMaxResults());
		pagination.setResultList(resultList);
		
	}

	@Override
	public void saveSaleVisit(SaleVisit saleVisit) {
		System.out.println(saleVisit);
		saleVisitDAO.save(saleVisit);
		
	}


}
