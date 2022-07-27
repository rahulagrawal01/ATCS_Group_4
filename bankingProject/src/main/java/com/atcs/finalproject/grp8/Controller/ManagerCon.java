package com.atcs.finalproject.grp8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.atcs.finalproject.grp8.Entity.ManagerEntity;
import com.atcs.finalproject.grp8.Entity.employeeEntity;
import com.atcs.finalproject.grp8.Repo.managerRepo;
import com.atcs.finalproject.grp8.ServiceImp.Employeeserimpl;
import com.atcs.finalproject.grp8.ServiceImp.ManagerSerimpl;

@RestController
@RequestMapping("/manager")

public class ManagerCon {
	@Autowired
	managerRepo mr;
	@Autowired
	ManagerSerimpl m_imp;
	@Autowired
Employeeserimpl e_imp;
	@GetMapping("/get")
	public List<ManagerEntity> getdata(){
		return m_imp.getdata() ;
	}
	@GetMapping("{id}")
	public ManagerEntity getdatabyid(@PathVariable("id")int manager_id) {
		return m_imp.getdatabyid(manager_id);
	}
	@GetMapping("/v")
	public List<employeeEntity> getdatabyid() {
		return e_imp.getdata();
	}
	
	@PostMapping("/")
	public List<ManagerEntity> postdata(@RequestBody ManagerEntity mh){
		return m_imp.postdata(mh);
	}
	@PutMapping("/")
	public List<ManagerEntity> putdata(@RequestBody ManagerEntity mh){
		return m_imp.putdata(mh); 
	}
	

}
