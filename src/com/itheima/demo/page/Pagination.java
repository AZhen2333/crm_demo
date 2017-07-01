package com.itheima.demo.page;
//分页bean：用来存放封装分页相关请求和响应的数据

import java.util.List;
import java.util.Map;

public class Pagination<T> {

	//请求
	private int page=1;//页码,默认设置为1
	private int pageSize=2;//每页最大记录数，每页默认显示2条
//	private T paramModel;//封装实体参数对象
	private Map<String, String[]> parameterMap;
	
	//响应
	private List<T> resultList;//当前页的列表
	private Long totalCount;//总记录数
	private Long totalPage;//总页数
	
	//定义分页数据计算
	//起始索引
	public int getFirstResult (){
		return (page-1)*pageSize;
	}
	

	//每页最大查询的行数
	public int getMaxResults(){
		return pageSize;
	}
	
	
	public Map<String, String[]> getParameterMap() {
		return parameterMap;
	}

	public void setParameterMap(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getResultList() {
		return resultList;
	}
	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
		//计算页数
		this.totalPage=(totalCount+pageSize-1)/pageSize;
		
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}


	@Override
	public String toString() {
		return "Pagination [page=" + page + ", pageSize=" + pageSize + ", parameterMap=" + parameterMap
				+ ", resultList=" + resultList + ", totalCount=" + totalCount + ", totalPage=" + totalPage + "]";
	}
	
	
	
}
