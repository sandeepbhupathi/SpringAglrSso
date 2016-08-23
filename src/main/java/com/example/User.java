package com.example;


import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {

	private long id;
	private String userName;

	Set<UserAuthority> userAuth;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return userAuth;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	public void setId(long l) {
		this.id = l;
		
	}

	public void setUsername(String userName) {
		this.userName = userName;
		
	}

	public void setRoles(Set<UserAuthority> roles) {
		this.userAuth=roles;
	}

	
}
