package com.atcs.finalproject.grp8.ServiceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Entity.CurrentAcc;
import com.atcs.finalproject.grp8.Entity.SavingAcc;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.Repo.currentRepo;
import com.atcs.finalproject.grp8.Repo.savingRepo;
import com.atcs.finalproject.grp8.Services.SavingService;

@Component

public class SavingAccserimpl  implements SavingService{
	@Autowired
	savingRepo sr1;
	@Autowired
	AccHolderimpl ar;
	@Autowired
	AccholderRepo ar1;


	@Override
	public List<SavingAcc> getdata() {
		// TODO Auto-generated method stub
		return sr1.findAll();
	}

	@Override
	public SavingAcc getdatabyid(long Acc_noS) {
		// TODO Auto-generated method stub
		SavingAcc s= sr1.findById( Acc_noS).get();
		return s;
		
		
	}

	@Override
	public List<SavingAcc> postdata(SavingAcc s) {
		// TODO Auto-generated method stub
		sr1.save(s);
		return sr1.findAll();
		
	}

	@Override
	public List<SavingAcc> putdata(SavingAcc s) {
		// TODO Auto-generated method stub
		sr1.save(s);
		return sr1.findAll();
		
	}

	

	@Override
	public List<SavingAcc> deletedata(long Acc_noS) {
		// TODO Auto-generated method stub
		sr1.deleteById(Acc_noS);
		return sr1.findAll();
		
		
	}
	@Override
	public double  putdatabypin(double balance, SavingAcc c) {
		// TODO Auto-generated method stub

		SavingAcc a = new SavingAcc();
		AccHolder obj = new AccHolder();
		double q = 0;
		long k = c.getAcc_noS();

		System.out.println(sr1.existsByAcc_noS(k));
		if (sr1.existsByAcc_noS(k)) {
			a = getdatabyid(k);
			if (a.getPin_S() == c.getPin_S()) {
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
	public double putdatabypinwithdraw(double balance, SavingAcc c) {
		// TODO Auto-generated method stub
		SavingAcc a = new SavingAcc();
		AccHolder obj = new AccHolder();
		double q = obj.getBalance();
		long k = c.getAcc_noS();
		double b=0;

		System.out.println(sr1.existsByAcc_noS(k));
		if (sr1.existsByAcc_noS(k)) {
			a = getdatabyid(k);
			// double b=obj.getBalance();
			if (a.getPin_S() == c.getPin_S()) {
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
