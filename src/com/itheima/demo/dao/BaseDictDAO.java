package com.itheima.demo.dao;

import java.util.List;

import com.itheima.demo.domain.BaseDict;

public interface BaseDictDAO {

	public List<BaseDict> findSourceByTypeCode(String dict_type_code);

}
