package com.itheima.demo.service;

import com.itheima.demo.domain.SaleVisit;
import com.itheima.demo.page.Pagination;

public interface SaleVisitService {

	public void findSaleVisitListPage(Pagination<SaleVisit> pagination);


	public void saveSaleVisit(SaleVisit saleVisit);

}
