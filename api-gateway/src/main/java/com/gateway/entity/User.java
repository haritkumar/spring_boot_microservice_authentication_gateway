package com.gateway.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Email(message = "*Please provide a valid email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@NotEmpty(message = "*Please provide your password")
	private String password;
	
	@NotEmpty(message = "*Please provide your first name")
	private String name;
	
	@NotEmpty(message = "*Please provide your last name")
	private String lastName;
	
	private Integer active = 1;
	private boolean isLoacked = false;
	private boolean isExpired = false;
	private boolean isEnabled = true;
	
	@OneToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="token_id")
	private JwtToken jwtToken;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public boolean isLoacked() {
		return isLoacked;
	}
	public void setLoacked(boolean isLoacked) {
		this.isLoacked = isLoacked;
	}
	public boolean isExpired() {
		return isExpired;
	}
	public void setExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	
	public JwtToken getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(JwtToken jwtToken) {
		this.jwtToken = jwtToken;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", lastName="
				+ lastName + ", active=" + active + ", isLoacked=" + isLoacked + ", isExpired=" + isExpired
				+ ", isEnabled=" + isEnabled + ", role=" + role + ", jwtToken=" + jwtToken + "]";
	}


}
