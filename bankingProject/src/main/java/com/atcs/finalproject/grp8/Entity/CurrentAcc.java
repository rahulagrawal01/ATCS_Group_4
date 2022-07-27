package com.atcs.finalproject.grp8.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CurrentAccount")

public class CurrentAcc {
	@Id
	long Acc_noC;
	@Column
	int pin_c;
	@OneToOne
	AccHolder user_id;
	public CurrentAcc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CurrentAcc(long acc_noC, int pin_c, AccHolder user_id) {
		super();
		Acc_noC = acc_noC;
		this.pin_c = pin_c;
		this.user_id = user_id;
	}
	public long getAcc_noc() {
		return Acc_noC;
	}
	public void setAcc_noc(long acc_noc) {
		Acc_noC = acc_noc;
	}
	public int getPin() {
		return pin_c;
	}
	public void setPin(int pin) {
		this.pin_c = pin;
	}
	public AccHolder getUser_id() {
		return user_id;
	}
	public void setUser_id(AccHolder user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "CurrentAcc [Acc_noc=" + Acc_noC + ", pin=" + pin_c + ", user_id=" + user_id + "]";
	}
	
	

}
