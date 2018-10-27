package com.cg.springmvcpractice.service;

import java.util.List;

import com.cg.springmvcpractice.dto.Mobile;

public interface IMobileService {
	public void addMobile(Mobile mobile);
	public List<Mobile> showAllMobile();
	public void deleteMobile(int mobId);
	public Mobile searchMobile(int mobId);
	public void updateMobile(Integer mobId,double mobPrice);

}
