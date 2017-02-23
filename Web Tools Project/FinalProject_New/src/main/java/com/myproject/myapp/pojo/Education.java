package com.myproject.myapp.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Education {
	
	@Id
	@GeneratedValue
	private long eduId;
	private String schoolName;
	public String level;
	
	
	@ManyToOne
	@JoinColumn(name="userid")
	private Candidate candidate;
	
	private String yearAttendedFrom;
	private String yearAttendedTo;
	private String major;
	
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getYearAttendedFrom() {
		return yearAttendedFrom;
	}
	public void setYearAttendedFrom(String yearAttendedFrom) {
		this.yearAttendedFrom = yearAttendedFrom;
	}
	public String getYearAttendedTo() {
		return yearAttendedTo;
	}
	public void setYearAttendedTo(String yearAttendedTo) {
		this.yearAttendedTo = yearAttendedTo;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public long getEduId() {
		return eduId;
	}
	public void setEduId(long eduId) {
		this.eduId = eduId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	
	
	
}
