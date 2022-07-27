package com.atcs.finalproject.grp8.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.atcs.finalproject.grp8.Entity.employeeEntity;
import com.atcs.finalproject.grp8.Repo.employeeRepo1;
import com.atcs.finalproject.grp8.Services.employeSer;

@Component

public class Employeeserimpl implements employeSer  {
	@Autowired
	employeeRepo1 er;

	@Override
	public List<employeeEntity> getdata() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public employeeEntity getdatabyid(int emp_id) {
		// TODO Auto-generated method stub
		employeeEntity e= er.findById(emp_id).get();
		return e;
		
	
	}

	@Override
	public List<employeeEntity> postdata(employeeEntity emp) {
		// TODO Auto-generated method stub
		er.save(emp);
		return er.findAll();
		
	}

	@Override
	public List<employeeEntity> putdata(employeeEntity emp) {
		// TODO Auto-generated method stub
		er.save(emp);
		return er.findAll();
		
	}

}
