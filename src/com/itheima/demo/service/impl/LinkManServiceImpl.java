package com.itheima.demo.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import com.itheima.demo.dao.LinkManDAO;
import com.itheima.demo.domain.LinkMan;
import com.itheima.demo.page.Pagination;
import com.itheima.demo.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {
	// 注入
	private LinkManDAO linkManDAO;

	

	public void setLinkManDAO(LinkManDAO linkManDAO) {
		this.linkManDAO = linkManDAO;
	}

	@Override
	public void findLinkManListPage(Pagination<LinkMan> pagination) {
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		// 条件查询
		Map<String, String[]> parameterMap = pagination.getParameterMap();
		// 客户姓名
		String lkm_name = parameterMap.get("lkm_name") == null ? null : parameterMap.get("lkm_name")[0];
		if (StringUtils.isNotBlank(lkm_name)) {// 不为空，模糊匹配
			criteria.add(Restrictions.like("lkm_name", lkm_name, MatchMode.ANYWHERE));
		}
		// 手机号码
		String lkm_gender = parameterMap.get("lkm_gender") == null ? null : parameterMap.get("lkm_gender")[0];
		if (StringUtils.isNotBlank(lkm_gender)) {// 不为空，模糊匹配
			criteria.add(Restrictions.eq("lkm_gender", lkm_gender));
		}

		// 1.查询总条数
		System.out.println("service");
		Long totalCount = linkManDAO.findCount(criteria);
		System.out.println("总条数" + totalCount);
		// 封装结果
		pagination.setTotalPage(totalCount);
		// 2.查询每页的数据
		List<LinkMan> resultList = linkManDAO.findResultList(criteria, pagination.getFirstResult(),
				pagination.getMaxResults());
		System.out.println("====" + resultList.toString());
		pagination.setResultList(resultList);
	}



	@Override
	public LinkMan findLinkManByID(Long lkm_id) {
		return linkManDAO.findLinkManByID(lkm_id);
	}

	@Override
	public void updateLiakMan(LinkMan linkMan) {
		linkManDAO.updateLinkMan(linkMan);
		
	}

	@Override
	public void deleteLinkMan(LinkMan linkMan) {
		linkManDAO.deleteLinkMan(linkMan);
		
	}

}
