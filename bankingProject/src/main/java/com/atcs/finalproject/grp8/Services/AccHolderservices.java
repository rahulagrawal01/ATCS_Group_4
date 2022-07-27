package com.atcs.finalproject.grp8.Services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.atcs.finalproject.grp8.Entity.AccHolder;

public interface AccHolderservices {
	public List<AccHolder> getdata();
	public AccHolder getdatabyid(@PathVariable("id")int user_id) ;
	public List<AccHolder> postdata(@RequestBody AccHolder h);
	public List<AccHolder> putdata(@RequestBody AccHolder h);
	public List<AccHolder> deletedata(@PathVariable("id") int user_id);
	public List<AccHolder> getdatabyage(@PathVariable("age")int age);
	public List<AccHolder> getdatabyname( @PathVariable("user_name")String user_name);
	public List<AccHolder> getdatabylocation( @PathVariable("location")String location);
	public AccHolder putbalance( @PathVariable("user_id") int user_id, @PathVariable("balance") double balance);
	public List<AccHolder> putdataintrest();
	public double gettotal();


}
