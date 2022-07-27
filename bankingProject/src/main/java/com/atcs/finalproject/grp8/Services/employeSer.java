package com.atcs.finalproject.grp8.Services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.atcs.finalproject.grp8.Entity.employeeEntity;

public interface employeSer {
	public List<employeeEntity> getdata();
	public employeeEntity getdatabyid(@PathVariable("id")int emp_id) ;
	public List<employeeEntity> postdata(@RequestBody employeeEntity emp);
	public List<employeeEntity> putdata(@RequestBody employeeEntity emp);

}
