package com.example.Final.LMS.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="enroll")
public class Enroll {
	

	public Enroll() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Enroll(long id, List<Courses> course, User user) {
		this.id = id;
		this.course = course;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Courses> getCourse() {
		return course;
	}

	public void setCourse(List<Courses> course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Enroll [enrollId=" + id + ", course=" + course + ", user=" + user + "]";
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToMany
	private List<Courses> course;
	
	@OneToOne
	User user;

}

