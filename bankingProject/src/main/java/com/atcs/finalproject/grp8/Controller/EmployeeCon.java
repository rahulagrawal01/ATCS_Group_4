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

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.employeeEntity;
import com.atcs.finalproject.grp8.Repo.employeeRepo1;
import com.atcs.finalproject.grp8.ServiceImp.AccHolderimpl;
import com.atcs.finalproject.grp8.ServiceImp.Employeeserimpl;

@RestController
@RequestMapping("/employee")

public class EmployeeCon {
	@Autowired
	 employeeRepo1 emp_r;
	@Autowired
	
	Employeeserimpl imp_obj;
	@Autowired
	AccHolderimpl a_imp;
	
	
	
	
	@GetMapping("/get")
	public List<employeeEntity> getdata(){
		return  imp_obj.getdata();
	}
	@GetMapping("{id}")
	public employeeEntity getdatabyid(@PathVariable("id")int emp_id) {
		return imp_obj.getdatabyid(emp_id);
	}
	@GetMapping("/u")
	public List<AccHolder> getdatabyid() {
		return a_imp.getdata();
	}
	
	@PostMapping("/")
	public List<employeeEntity> postdata(@RequestBody employeeEntity emp){
		return imp_obj.postdata(emp);
	}
	@PutMapping("manager/updateemp")
	public List<employeeEntity> putdata(@RequestBody employeeEntity emp){
		return imp_obj.putdata(emp); 
	}

}
