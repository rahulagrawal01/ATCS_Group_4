package com.atcs.finalproject.grp8.Services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.atcs.finalproject.grp8.Entity.CurrentAcc;
import com.atcs.finalproject.grp8.Entity.SavingAcc;

public interface SavingService {
	public List<SavingAcc> getdata();
	public SavingAcc getdatabyid(@PathVariable("id")long Acc_noS) ;
	public List<SavingAcc> postdata(@RequestBody SavingAcc s);
	public List<SavingAcc> putdata(@RequestBody SavingAcc s);
	public List<SavingAcc> deletedata(@PathVariable("id") long Acc_noS);
	public double putdatabypin( @PathVariable("balance")double balance,@RequestBody SavingAcc s) ;
	public double putdatabypinwithdraw( @PathVariable("balance")double balance,@RequestBody SavingAcc s );


}
