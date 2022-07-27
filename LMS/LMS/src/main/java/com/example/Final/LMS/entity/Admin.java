package com.example.Final.LMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="admin", uniqueConstraints = @UniqueConstraint(
        name = "emailid_unique",
        columnNames = "adminEmail"
        ))

public class Admin {

	public Admin() {
		super();

	}
	public Admin(long adminId, String adminName, String adminEmail) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminEmail = adminEmail;

	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long adminId;
	
	@Column
	 String adminName;
	
	@Column
	 String adminEmail;
		
}