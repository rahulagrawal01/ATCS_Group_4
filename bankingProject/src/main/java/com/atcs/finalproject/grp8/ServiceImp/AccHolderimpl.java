package com.atcs.finalproject.grp8.ServiceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.atcs.finalproject.grp8.Entity.AccHolder;
import com.atcs.finalproject.grp8.Repo.AccholderRepo;
import com.atcs.finalproject.grp8.Services.AccHolderservices;

@Component

public class AccHolderimpl implements AccHolderservices {
	@Autowired
	AccholderRepo AccH_repo;

	@Override
	public List<AccHolder> getdata() {
		// TODO Auto-generated method stub
		return AccH_repo.findAll();
	}

	@Override
	public AccHolder getdatabyid(int user_id) {
		// TODO Auto-generated method stub
		AccHolder h = AccH_repo.findById(user_id).get();
		return h;

	}

	@Override

	public List<AccHolder> getdatabyage(int age) {
		// TODO Auto-generated method stub
		List<AccHolder> h1;
		AccHolder h;
		int k = 0;
		AccHolder o = new AccHolder();
		List<AccHolder> holder = new ArrayList<AccHolder>();

		h1 = AccH_repo.findAll();
		for (AccHolder p : h1) {
			if (p.getAge() == age) {
				// k = p.getUser_id();
				// o = getdatabyid(k);

				holder.add(p);
			}
		}
		return holder;

	}

	@Override

	public List<AccHolder> getdatabyname(String user_name) {
		// TODO Auto-generated method stub
		List<AccHolder> h1;
		AccHolder h;
		int k = 0;
		AccHolder o = new AccHolder();
		List<AccHolder> holder = new ArrayList<AccHolder>();

		h1 = AccH_repo.findAll();

		for (AccHolder p : h1) {

			if (p.getUser_name().equals(user_name)) {
				k = p.getUser_id();
				o = getdatabyid(k);
				holder.add(o);

			}

		}

		return holder;

	}

	@Override

	public List<AccHolder> getdatabylocation(String location) {
		// TODO Auto-generated method stub
		List<AccHolder> h1;
		AccHolder h;
		int k = 0;
		AccHolder o = new AccHolder();
		List<AccHolder> holder = new ArrayList<AccHolder>();

		h1 = AccH_repo.findAll();

		for (AccHolder p : h1) {

			if (p.getLocation().equals(location)) {
				k = p.getUser_id();
				o = getdatabyid(k);
				holder.add(o);

			}

		}

		return holder;

	}

	@Override
	public List<AccHolder> postdata(AccHolder h) {
		// TODO Auto-generated method stub
		if (h.getBalance() >= 500) {
			AccH_repo.save(h);

		} else {
			System.out.println("enter amount greater than 500");

		}
		return AccH_repo.findAll();

	}

	@Override
	public List<AccHolder> putdata(AccHolder h) {
		// TODO Auto-generated method stub
		AccH_repo.save(h);
		return AccH_repo.findAll();

	}

	@Override
	public List<AccHolder> deletedata(int user_id) {
		// TODO Auto-generated method stub
		AccH_repo.deleteById(user_id);
		return AccH_repo.findAll();

	}

	public AccHolder putbalance(int user_id, double balance) {
		// TODO Auto-generated method stub
		double k = 0;

		AccHolder h = getdatabyid(user_id);

		k = h.getBalance() + balance;

		h.setBalance(k);
		AccH_repo.save(h);

		return h;
	}

	@Override
	public List<AccHolder> putdataintrest() {
		// TODO Auto-generated method stub
		List<AccHolder> h2;
		double final_amnt = 0;

		h2 = AccH_repo.findAll();
		for (AccHolder o1 : h2) {
			double b1 = o1.getBalance();

			final_amnt = ((b1 * 5) / 100) + b1;
			o1.setBalance(final_amnt);

			AccH_repo.save(o1);

		}

		return h2;
	}

	@Override
	public double gettotal() {
		// TODO Auto-generated method stub
		double total_amnt = 0;
		List<AccHolder> h2;

		h2 = AccH_repo.findAll();
		for (AccHolder o1 : h2) {
			double b1 = o1.getBalance();

			total_amnt += b1;
			

			
		
	}
		return total_amnt;
	}

}
