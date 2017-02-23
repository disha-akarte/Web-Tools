package com.myproject.myapp.pojo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="UserAccount")
@Inheritance(strategy=InheritanceType.JOINED)
public class UserAccount {

	@Id
	@GeneratedValue
	@Column(name = "userid", unique = true, nullable = false)
	private long id; 
	
	
	@Column(name = "password")
	private String password;
	
	
	@Column(name = "emailId")
	private String emailId;
	
	@Transient
	private String confirmPassword;
	
	private String type;
	
	public UserAccount(String emailId, String password, String confirmPassword) {
        this.emailId = emailId;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UserAccount() {
    }

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
	
}
