package com.itheima.demo.service;

import com.itheima.demo.domain.LinkMan;
import com.itheima.demo.page.Pagination;

public interface LinkManService {


	public void findLinkManListPage(Pagination<LinkMan> pagination);

	public LinkMan findLinkManByID(Long lkm_id);

	public void updateLiakMan(LinkMan linkMan);

	public void deleteLinkMan(LinkMan linkMan);

}
