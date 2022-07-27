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
@Table(name="employeDetail")

public class employeeEntity {
	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	int emp_id;
	@Column
	String name;
	@Column
	double salary;
	@Column
	String branch;
	@OneToMany
	List<AccHolder> user_id;
	public employeeEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employeeEntity(int emp_id, String name, double salary, String branch, List<AccHolder> user_id) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.salary = salary;
		this.branch = branch;
		this.user_id = user_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public List<AccHolder> getUser_id() {
		return user_id;
	}
	public void setUser_id(List<AccHolder> user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "employeeEntity [emp_id=" + emp_id + ", name=" + name + ", salary=" + salary + ", branch=" + branch
				+ ", user_id=" + user_id + "]";
	}
	
	

}
