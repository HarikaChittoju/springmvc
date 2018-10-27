package com.cg.springmvcpractice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.springmvcpractice.dao.IMobileDao;
import com.cg.springmvcpractice.dto.Mobile;
@Service("mobileservice")
@Transactional
public class MobileServiceImpl implements IMobileService{

	@Autowired
	IMobileDao mobiledao;
	
	@Override
	public void addMobile(Mobile mobile) {
		mobiledao.addMobile(mobile);
		
	}

	@Override
	public List<Mobile> showAllMobile() {
		// TODO Auto-generated method stub
		return mobiledao.showAllMobile();
	}

	@Override
	public void deleteMobile(int mobId) {
		// TODO Auto-generated method stub
	 mobiledao.deleteMobile(mobId);
	}

	@Override
	public Mobile searchMobile(int mobId) {
		// TODO Auto-generated method stub
		return mobiledao.searchMobile(mobId);
	}

	@Override
	public void updateMobile(Integer mobId,double mobPrice) {
		// TODO Auto-generated method stub
		mobiledao.updateMobile(mobId,mobPrice);
	}

}
