package com.atcs.finalproject.grp8.Services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.atcs.finalproject.grp8.Entity.ManagerEntity;

public interface Managerservice {
	public List<ManagerEntity> getdata();
	public ManagerEntity getdatabyid(@PathVariable("id")int manager_id) ;
	public List<ManagerEntity> postdata(@RequestBody ManagerEntity mh);
	public List<ManagerEntity> putdata(@RequestBody ManagerEntity mh);

}
