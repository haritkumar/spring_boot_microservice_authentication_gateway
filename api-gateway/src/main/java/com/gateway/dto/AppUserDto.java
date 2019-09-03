package com.gateway.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class AppUserDto {

	@NotEmpty(message = "*Please provide your first name")
	private String fname;
	
	private String lname;
	
	@Email(message = "*Please provide a valid email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@NotEmpty(message = "*Please provide your password")
	private String password;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AppUserDto [fname=" + fname + ", lname=" + lname + ", email=" + email + ", password=" + password + "]";
	}
	
	
}
