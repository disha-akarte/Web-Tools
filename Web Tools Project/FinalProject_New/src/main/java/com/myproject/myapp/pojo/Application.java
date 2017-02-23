package com.myproject.myapp.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Application {

	@Id
	@GeneratedValue
	private int appID;
	
	
	private String status;	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
    @Column(unique=true)
	private long jobID;
	private long employeeID;
	private long candidateID;
	
	public long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(long employeeID) {
		this.employeeID = employeeID;
	}
	public long getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(long candidateID) {
		this.candidateID = candidateID;
	}
	public long getJobID() {
		return jobID;
	}
	public void setJobID(long jobID) {
		this.jobID = jobID;
	}
	public int getAppID() {
		return appID;
	}
	public void setAppID(int appID) {
		this.appID = appID;
	}
	
	
	
}
