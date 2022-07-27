package com.atcs.finalproject.grp8.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.BranchDetail;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.ServiceImp.AccHolderimpl;

@RestController
@RequestMapping("/Accholder")

public class AccHoldercon {
	@Autowired
	AccholderRepo holder_obj;
	@Autowired
	AccHolderimpl H_imp;
	@GetMapping("/get")
	public List<AccHolder> getdata(){
		return H_imp.getdata() ;
	}
	@GetMapping("{id}")
	public AccHolder getdatabyid(@PathVariable("id")int user_id) {
		return H_imp.getdatabyid(user_id);
	}
	@GetMapping("age/{age}")
	public List<AccHolder> getdatabyage(@PathVariable("age")int  age) {
		return H_imp.getdatabyage(age);
	}
	@GetMapping("name/{user_name}")
	public List<AccHolder> getdatabyname(@PathVariable("user_name")String user_name) {
		return H_imp.getdatabyname(user_name);
	}
	@GetMapping("location/{location}")
	public List<AccHolder> getdatabylocation(@PathVariable("location")String location) {
		return H_imp.getdatabylocation(location);
	}
	@GetMapping("/total")
	public double gettotal() {
		return H_imp.gettotal();
	}
	
	
	
	@PostMapping("/")
	public List<AccHolder> postdata(@RequestBody AccHolder h){
		return H_imp.postdata(h);
	}
	@PutMapping("/")
	public List<AccHolder> putdata(@RequestBody AccHolder h){
		return H_imp.putdata(h); 
	}
	@PutMapping("/{user_id}/{balance}")
	public AccHolder putbalance (  @PathVariable("user_id") int user_id, @PathVariable("balance") double balance){
		return H_imp.putbalance(user_id,balance); 
	}
	@PutMapping("/intrest")
	public List<AccHolder> putdataintrest(){
		return H_imp.putdataintrest(); 
	}
	
	
	
	@DeleteMapping("/{id}")
	public List<AccHolder> deletedata(@PathVariable("id") int user_id){
		return H_imp.deletedata(user_id);
	}
	
	
	

}
