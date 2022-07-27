package com.atcs.finalproject.grp8.Services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.atcs.finalproject.grp8.Entity.CurrentAcc;

public interface currentAccservices {
	public List<CurrentAcc> getdata();
	public CurrentAcc getdatabyid(@PathVariable("id")long Acc_noC) ;
	public List<CurrentAcc> postdata(@RequestBody CurrentAcc c);
	public List<CurrentAcc> putdata(@RequestBody CurrentAcc c);
	public List<CurrentAcc> deletedata(@PathVariable("id") long Acc_noC);
	public double putdatabypin( @PathVariable("balance")double balance,@RequestBody CurrentAcc c) ;
	public double putdatabypinwithdraw( @PathVariable("balance")double balance,@RequestBody CurrentAcc c );

}
