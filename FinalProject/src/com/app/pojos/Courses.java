package com.app.pojos;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_details")
public class Courses {
	@Id
	@Column(name = "course_id")
	private String courseId;
	@Column(name = "course_name")
	private String courseName;
	@Column(name = "course_duration")
	private BigDecimal courseDuration;
	public Courses() {
	}
	public Courses(String courseId, String courseName, BigDecimal courseDuration) {
		//super();
		this.courseId = courseId;
		//this.faculty_id = courseName;
		this.courseDuration = courseDuration;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	
	public BigDecimal getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(BigDecimal courseDuration) {
		this.courseDuration = courseDuration;
	}
	@Override
	public String toString() {
		return "Courses [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration=" + courseDuration
				+ "]";
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	

}
