package com.atcs.finalproject.grp8.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="savingAccount")

public class SavingAcc {
	@Id
	long acc_noS;
	@Column
	int pin_S;
	@OneToOne
	AccHolder user_id;
	public SavingAcc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SavingAcc(long acc_noS, int pin_S, AccHolder user_id) {
		super();
		this.acc_noS = acc_noS;
		this.pin_S = pin_S;
		this.user_id = user_id;
	}
	public long getAcc_noS() {
		return acc_noS;
	}
	public void setAcc_noS(long acc_noS) {
		this.acc_noS = acc_noS;
	}
	public int getPin_S() {
		return pin_S;
	}
	public void setPin_S(int pin_S) {
		this.pin_S = pin_S;
	}
	public AccHolder getUser_id() {
		return user_id;
	}
	public void setUser_id(AccHolder user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "SavingAcc [acc_noS=" + acc_noS + ", pin_S=" + pin_S + ", user_id=" + user_id + "]";
	}
	

}
