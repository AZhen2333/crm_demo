package com.itheima.demo.service;

import java.util.List;

import com.itheima.demo.domain.BaseDict;

public interface BaseDictService {

	public List<BaseDict> findSourceByTypeCode(String dict_type_code);

}
