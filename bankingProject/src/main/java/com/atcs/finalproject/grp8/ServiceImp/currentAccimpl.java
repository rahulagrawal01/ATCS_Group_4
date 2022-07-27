package com.atcs.finalproject.grp8.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.CurrentAcc;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.Repo.currentRepo;
import com.atcs.finalproject.grp8.Services.currentAccservices;

@Component

public class currentAccimpl implements currentAccservices {
	@Autowired
	currentRepo cr1;
	@Autowired
	AccHolderimpl ar;
	@Autowired
	AccholderRepo ar1;

	@Override
	public List<CurrentAcc> getdata() {
		// TODO Auto-generated method stub
		return cr1.findAll();
	}

	@Override
	public CurrentAcc getdatabyid(long Acc_noC) {
		// TODO Auto-generated method stub
		CurrentAcc c = cr1.findById(Acc_noC).get();
		return c;

	}

	@Override
	public List<CurrentAcc> postdata(CurrentAcc c) {
		// TODO Auto-generated method stub
		cr1.save(c);
		return cr1.findAll();

	}

	@Override
	public List<CurrentAcc> putdata(CurrentAcc c) {
		// TODO Auto-generated method stub
		cr1.save(c);
		return cr1.findAll();

	}

	@Override
	public double  putdatabypin(double balance, CurrentAcc c) {
		// TODO Auto-generated method stub

		CurrentAcc a = new CurrentAcc();
		AccHolder obj = new AccHolder();
		double q = 0;
		long k = c.getAcc_noc();

		System.out.println(cr1.existsByAcc_noC(k));
		if (cr1.existsByAcc_noC(k)) {
			a = getdatabyid(k);
			if (a.getPin() == c.getPin()) {
				System.out.println(balance);
				obj = ar.getdatabyid(c.getUser_id().getUser_id());
				System.out.println(obj.getBalance());
				q = obj.getBalance() + balance;
				obj.setBalance(q);
				ar1.save(obj);

			}

		}

		return q;

	}

	@Override
	public List<CurrentAcc> deletedata(long Acc_noC) {
		// TODO Auto-generated method stub
		cr1.deleteById(Acc_noC);
		return cr1.findAll();

	}

	@Override
	public double putdatabypinwithdraw(double balance, CurrentAcc c) {
		// TODO Auto-generated method stub
		CurrentAcc a = new CurrentAcc();
		AccHolder obj = new AccHolder();
		double q = obj.getBalance();
		long k = c.getAcc_noc();
		double b=0;

		System.out.println(cr1.existsByAcc_noC(k));
		if (cr1.existsByAcc_noC(k)) {
			a = getdatabyid(k);
			// double b=obj.getBalance();
			if (a.getPin() == c.getPin()) {
				System.out.println("need to add"+balance);
				obj = ar.getdatabyid(c.getUser_id().getUser_id());
				System.out.println("old bal"+obj.getBalance());
				//q = obj.getBalance() - balance;
				if(obj.getBalance() - balance>=500) {
					q=obj.getBalance() - balance; 
					
				
				obj.setBalance(q);
				System.out.println("balance="+obj.getBalance());
				ar1.save(obj);
				}
				 b =obj.getBalance();
			}

		}

		return b;
		
	
		
	}

}
