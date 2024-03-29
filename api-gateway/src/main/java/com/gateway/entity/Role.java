package com.gateway.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String role;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Role{" + "id=" + id + ", role='" + role + '\'' + '}';
	}
}
