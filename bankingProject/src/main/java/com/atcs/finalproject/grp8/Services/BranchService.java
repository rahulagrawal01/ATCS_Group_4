package com.atcs.finalproject.grp8.Services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.BranchDetail;

public interface BranchService {
	public List<BranchDetail> postdata(BranchDetail bh);
	public List<BranchDetail> getdata();
	public BranchDetail getdatabyid(@PathVariable("id")int branch_id) ;
	
	public List<BranchDetail> putdata(@RequestBody BranchDetail  bh);
	public List<BranchDetail> deletedata(@PathVariable("id") int branch_id);
	public List<AccHolder> getdatabybranchid( @PathVariable("branch_id")int branch_id);


}
