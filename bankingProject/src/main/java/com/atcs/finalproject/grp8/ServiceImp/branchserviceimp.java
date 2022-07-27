package com.atcs.finalproject.grp8.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.BranchDetail;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.Repo.branchRepo;
import com.atcs.finalproject.grp8.Services.BranchService;

@Component

public class branchserviceimp implements BranchService {
	@Autowired
	branchRepo br;
	@Autowired
	AccholderRepo ar;

	@Override
	public List<BranchDetail> postdata(BranchDetail bh) {
		// TODO Auto-generated method stub
		br.save(bh);
		return br.findAll();
	}

	@Override
	public List<BranchDetail> getdata() {
		// TODO Auto-generated method stub
		return br.findAll();
	}

	@Override
	public BranchDetail getdatabyid(int branch_id) {
		// TODO Auto-generated method stub
		 BranchDetail b= br.findById(branch_id).get();
		return b;
	}
	public AccHolder getdatabyidbranch(int user_id) {
		// TODO Auto-generated method stub
		AccHolder h = ar.findById(user_id).get();
		return h;

	}

	@Override

	public List<AccHolder> getdatabybranchid(int branch_id) {
		// TODO Auto-generated method stub
		List<AccHolder> h1;
		AccHolder h;
		int k = 0;
		AccHolder o = new AccHolder();
		List<AccHolder> holder = new ArrayList<AccHolder>();
		
		int r;

		h1 = ar.findAll();
		for (AccHolder p : h1) {
			
			
			r= p.getBranch_id().getBranch_id();
			
			System.out.print("user branc id -----");
			System.out.println(r);
			
			System.out.print("postman branch id ----");
			System.out.println(branch_id);
			
			
			if (r == branch_id) {
				k = p.getUser_id();
				System.out.println(k);
				
				o = getdatabyidbranch(k);
				holder.add(o);
			}
		}
		return holder;

	}


	@Override
	public List<BranchDetail> putdata(BranchDetail bh) {
		// TODO Auto-generated method stub
		br.save(bh);
		return br.findAll();
		
		
	}

	@Override
	public List<BranchDetail> deletedata(int branch_id) {
		// TODO Auto-generated method stub
		br.deleteById(branch_id);
		return br.findAll();
		
	}

}
