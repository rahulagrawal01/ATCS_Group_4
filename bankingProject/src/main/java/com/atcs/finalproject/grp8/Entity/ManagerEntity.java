package com.atcs.finalproject.grp8.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="manager")

public class ManagerEntity {
	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	int manager_id;
	@OneToMany
	List<employeeEntity> emp_id;
	public ManagerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ManagerEntity(int manager_id, List<employeeEntity> emp_id) {
		super();
		this.manager_id = manager_id;
		this.emp_id = emp_id;
	}
	public int getManager_id() {
		return manager_id;
	}
	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public List<employeeEntity> getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(List<employeeEntity> emp_id) {
		this.emp_id = emp_id;
	}
	@Override
	public String toString() {
		return "ManagerEntity [manager_id=" + manager_id + ", emp_id=" + emp_id + "]";
	}
	

}
