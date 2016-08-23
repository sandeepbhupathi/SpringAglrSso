package com.example;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority {

	private String auth;
	
	public UserAuthority(String auth) {
		this.auth=auth;
	}
	public void setAuthority(String auth){
		this.auth=auth;
	}
	@Override
	public String getAuthority() {
		return auth;
	}

}

