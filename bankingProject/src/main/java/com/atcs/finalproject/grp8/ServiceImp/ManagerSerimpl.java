package com.atcs.finalproject.grp8.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.ManagerEntity;

import com.atcs.finalproject.grp8.Repo.managerRepo;
import com.atcs.finalproject.grp8.Services.Managerservice;

@Component

public class ManagerSerimpl implements Managerservice {
	@Autowired
	managerRepo m_r;

	@Override
	public List<ManagerEntity> getdata() {
		// TODO Auto-generated method stub
		return m_r.findAll();
	}

	@Override
	public ManagerEntity getdatabyid(int manager_id) {
		// TODO Auto-generated method stub
		ManagerEntity em= m_r.findById(manager_id).get();
		return em;
		
		
	}

	@Override
	public List<ManagerEntity> postdata(ManagerEntity mh) {
		// TODO Auto-generated method stub
		m_r.save(mh);
		return m_r.findAll();
		
		
	}

	@Override
	public List<ManagerEntity> putdata(ManagerEntity mh) {
		// TODO Auto-generated method stub
		m_r.save(mh);
		return m_r.findAll();
	
	}

}
