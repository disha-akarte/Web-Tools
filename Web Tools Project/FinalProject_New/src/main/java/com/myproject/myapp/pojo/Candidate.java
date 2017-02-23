package com.myproject.myapp.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.mail.Multipart;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.springframework.web.multipart.MultipartFile;


@Entity
@PrimaryKeyJoinColumn(name="userid")
public class Candidate extends UserAccount {

	@Column(name = "firstName")
	private String first;
		
	private String last;
	private String address;
	private String phone;	
		
	@Lob
	@Column(name="cand_img",columnDefinition="mediumblob")
	private byte[] img;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Education> edu = new HashSet<Education>();
		
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private Set<Skills> skills = new HashSet<Skills>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Career> exp = new HashSet<Career>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<Application> appl = new HashSet<Application>();
	
	private String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Candidate(String emailId, String password, String confirmPassword, String firstName, String lastName,
			String fileName,String address,String phone, byte[] img) {
			this.setEmailId(emailId);
			this.setPassword(password);
			this.setConfirmPassword(confirmPassword);
			this.setFirst(firstName);
			this.setLast(lastName);
			this.setAddress(address);
			this.setPhone(phone);
			this.setFileName(fileName);
			this.setImg(img);
			super.setType("Candidate");

	}

	public Candidate() {
		
	}
	
	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
		
	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public Set<Education> getEdu() {
		return edu;
	}

	public void setEdu(Set<Education> edu) {
		this.edu = edu;
	}

	public Set<Career> getExp() {
		return exp;
	}

	public void setExp(Set<Career> exp) {
		this.exp = exp;
	}

	public Set<Application> getAppl() {
		return appl;
	}

	public void setAppl(Set<Application> appl) {
		this.appl = appl;
	}
	
}
