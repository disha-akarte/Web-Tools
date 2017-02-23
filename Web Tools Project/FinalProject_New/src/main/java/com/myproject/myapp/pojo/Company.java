package com.myproject.myapp.pojo;

import java.util.HashSet;
//import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="userid")
public class Company extends UserAccount{

//	@Id
//	@GeneratedValue
//	@Column(name = "companyID", unique = true, nullable = false)
//	private long companyID;
	
	private String companyName;
	private String location;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Job> jobs = new HashSet<Job>();
	
	public Company(){	
		
	}
	
	public Company(String username, String password, String confirmPassword, String companyName, String location) {
		super(username, password, confirmPassword);
		this.companyName = companyName;
		this.location = location;
		super.setType("Employer");
	}
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Set<Job> getJobs() {
		return jobs;
	}
	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}
//	public long getCompanyID() {
//		return companyID;
//	}
//	public void setCompanyID(long companyID) {
//		this.companyID = companyID;
//	}
//	
	
}

