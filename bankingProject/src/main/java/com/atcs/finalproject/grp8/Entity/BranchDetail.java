package com.atcs.finalproject.grp8.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="branchdetails")


public class BranchDetail {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	int Branch_id;
	@Column
	int pin_code;
	@Column
	String branch_name; 
	@Column
	 String location;
	
	public BranchDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BranchDetail(int branch_id, int pin_code, String branch_name, String location) {
		super();
		Branch_id = branch_id;
		this.pin_code = pin_code;
		this.branch_name = branch_name;
		this.location = location;
	}

	public int getBranch_id() {
		return Branch_id;
	}

	public void setBranch_id(int branch_id) {
		Branch_id = branch_id;
	}

	public int getPin_code() {
		return pin_code;
	}

	public void setPin_code(int pin_code) {
		this.pin_code = pin_code;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "BranchDetail [Branch_id=" + Branch_id + ", pin_code=" + pin_code + ", branch_name=" + branch_name
				+ ", location=" + location + "]";
	}
	
}
