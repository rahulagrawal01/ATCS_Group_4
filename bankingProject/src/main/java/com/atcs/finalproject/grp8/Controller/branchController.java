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
import com.atcs.finalproject.grp8.Repo.branchRepo;
import com.atcs.finalproject.grp8.ServiceImp.AccHolderimpl;
import com.atcs.finalproject.grp8.ServiceImp.branchserviceimp;

@RestController
@RequestMapping("/branch")


public class branchController {
	@Autowired
	branchRepo bh;
	@Autowired
	branchserviceimp bh_imp;
	@Autowired
	AccHolderimpl a_imp;
	
	@GetMapping("/get")
	public List<BranchDetail> getdata(){
		return bh_imp.getdata() ;
	}
	@GetMapping("{id}")
	public BranchDetail getdatabyid(@PathVariable("id")int Branch_id) {
		return bh_imp.getdatabyid(Branch_id);
	}
	@GetMapping("branch/{branch_id}")
	public List<AccHolder> getdatabybranchid(@PathVariable("branch_id")int Branch_id) {
		return bh_imp.getdatabybranchid(Branch_id);
	}
	
	@PostMapping("/")
	public List<BranchDetail> postdata(@RequestBody BranchDetail bh){
		return bh_imp.postdata(bh);
	}
	@PutMapping("/")
	public List<BranchDetail> putdata(@RequestBody BranchDetail bh){
		return bh_imp.putdata(bh); 
	}
	@DeleteMapping("/{id}")
	public List<BranchDetail> deletedata(@PathVariable("id") int Branch_id){
		return bh_imp.deletedata(Branch_id);
	}
	

}
