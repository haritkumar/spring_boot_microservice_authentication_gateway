package com.gateway.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class JwtToken {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    private String token;

    private String refreshToken;
    
	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtToken [id=" + id + ", token=" + token + ", refreshToken=" + refreshToken + "]";
	}

    
}
