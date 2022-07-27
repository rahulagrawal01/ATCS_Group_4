package com.example.Final.LMS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Courses {

	public Courses() {
		// TODO Auto-generated constructor stub
	}

	public Courses(long id, String courseName, String courseDescription, String courseLink, int courseDuration,
			int coursePrice) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseLink = courseLink;
		this.courseDuration = courseDuration;
		this.coursePrice = coursePrice;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public String getCourseLink() {
		return courseLink;
	}

	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String courseName;

	@Column
	private String courseDescription;

	@Column
	private String courseLink;

	@Column
	private int courseDuration;

	@Column
	private int coursePrice;


	@Override
	public String toString() {
		return "Courses [courseId=" + id + ", courseName=" + courseName + ", courseDescription=" + courseDescription
				+ ", courseLink=" + courseLink + ", courseDuration=" + courseDuration + ", coursePrice=" + coursePrice
				+ ", cart=" + "]";
	}

}
