package com.itheima.demo.domain;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Long cust_id;
	private String cust_name;
	private String cust_phone;
	private String cust_mobile;
	private String cust_filename;
	private String cust_path;
	
	private BaseDict baseDictSource;
	private BaseDict baseDictIndustry;
	private BaseDict baseDictLevel;
	
	//和联系人分建立联系
	private Set<LinkMan> linkManSet=new HashSet<>();

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_phone() {
		return cust_phone;
	}

	public void setCust_phone(String cust_phone) {
		this.cust_phone = cust_phone;
	}

	public String getCust_mobile() {
		return cust_mobile;
	}

	public void setCust_mobile(String cust_mobile) {
		this.cust_mobile = cust_mobile;
	}

	public String getCust_filename() {
		return cust_filename;
	}

	public void setCust_filename(String cust_filename) {
		this.cust_filename = cust_filename;
	}

	public String getCust_path() {
		return cust_path;
	}

	public void setCust_path(String cust_path) {
		this.cust_path = cust_path;
	}

	public BaseDict getBaseDictSource() {
		return baseDictSource;
	}

	public void setBaseDictSource(BaseDict baseDictSource) {
		this.baseDictSource = baseDictSource;
	}

	public BaseDict getBaseDictIndustry() {
		return baseDictIndustry;
	}

	public void setBaseDictIndustry(BaseDict baseDictIndustry) {
		this.baseDictIndustry = baseDictIndustry;
	}

	public BaseDict getBaseDictLevel() {
		return baseDictLevel;
	}

	public void setBaseDictLevel(BaseDict baseDictLevel) {
		this.baseDictLevel = baseDictLevel;
	}

	public Set<LinkMan> getLinkManSet() {
		return linkManSet;
	}

	public void setLinkManSet(Set<LinkMan> linkManSet) {
		this.linkManSet = linkManSet;
	}
	
	
	
	

}
