package com.example.Final.LMS.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	public User() {

	}

	public User(long id, String userName, String userEmail, String userMobile, String userOrganization, Admin admin) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userMobile = userMobile;
		this.userOrganization = userOrganization;
		this.admin = admin;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserOrganization() {
		return userOrganization;
	}

	public void setUserOrganization(String userOrganization) {
		this.userOrganization = userOrganization;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	 String userName;

	@Column
	String userEmail;
	
	@Column
	String userMobile;

	@Column
	String userOrganization;
	

    @OneToOne
	Admin admin;
    
    
}