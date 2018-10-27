package com.cg.springmvcpractice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.springmvcpractice.dto.Mobile;
@Repository("mobiledao")
public class IMobileDaoImpl implements IMobileDao {
	
	@PersistenceContext  //to link in dispatch
	EntityManager em;

	@Override
	public void addMobile(Mobile mobile) {
		// TODO Auto-generated method stub
	em.persist(mobile);  //toSava Data in db
	em.flush();
	}

	@Override
	public List<Mobile> showAllMobile() {
		// TODO Auto-generated method stub
		Query query= em.createQuery("FROM Mobile");
		List<Mobile> myAll =query.getResultList();
		return myAll;
	}

	@Override
	public void deleteMobile(int mobId) {
		// TODO Auto-generated method stub
		Query querydelete=em.createQuery("DELETE FROM Mobile WHERE mobId=:mobdata"); //here mobdata is any temporary variable
		querydelete.setParameter("mobdata",mobId);
		querydelete.executeUpdate();
		
	}

	@Override
	public Mobile searchMobile(int mobId) {
		// TODO Auto-generated method stub
		Query querysearch=em.createQuery("FROM Mobile WHERE mobId=:mobdata"); //here mobdata is any temporary variable
		querysearch.setParameter("mobdata",mobId);
		Mobile mob=(Mobile) querysearch.getResultList().get(0);
		return mob;
	}

	@Override
	public void updateMobile(Integer mobId, double mobPrice) {
		// TODO Auto-generated method stub
		Query queryupdate=em.createQuery("UPDATE FROM Mobile set mobPrice=:pr WHERE mobId=:mobdata"); //here mobdata is any temporary variable
		queryupdate.setParameter("mobdata",mobId);
		queryupdate.setParameter("pr",mobPrice);
        queryupdate.executeUpdate();
		
	}

}
