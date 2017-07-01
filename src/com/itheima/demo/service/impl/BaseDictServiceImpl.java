package com.itheima.demo.service.impl;

import java.util.List;

import com.itheima.demo.dao.BaseDictDAO;
import com.itheima.demo.domain.BaseDict;
import com.itheima.demo.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDAO baseDictDAO;
	public void setBaseDictDAO(BaseDictDAO baseDictDAO) {
		this.baseDictDAO = baseDictDAO;
	}


	@Override
	public List<BaseDict> findSourceByTypeCode(String dict_type_code) {
		System.out.println(dict_type_code);
		return baseDictDAO.findSourceByTypeCode(dict_type_code);
	}

}
