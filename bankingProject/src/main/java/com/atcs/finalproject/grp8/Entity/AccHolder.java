package com.atcs.finalproject.grp8.Entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="AcHolderdetails")

public class AccHolder {
	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	int user_id;
	@Column
	String user_name;
	@Column
	String location;
	@Column
	int age;
	@Column
	double balance;
	@OneToOne
	BranchDetail Branch_id;
	public AccHolder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccHolder(int user_id, String user_name, String location, int age, double balance, BranchDetail branch_id) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.location = location;
		this.age = age;
		this.balance = balance;
		Branch_id = branch_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public BranchDetail getBranch_id() {
		return Branch_id;
	}
	public void setBranch_id(BranchDetail branch_id) {
		Branch_id = branch_id;
	}
	@Override
	public String toString() {
		return "AccHolder [user_id=" + user_id + ", user_name=" + user_name + ", location=" + location + ", age=" + age
				+ ", balance=" + balance + ", Branch_id=" + Branch_id + "]";
	}
}	
	