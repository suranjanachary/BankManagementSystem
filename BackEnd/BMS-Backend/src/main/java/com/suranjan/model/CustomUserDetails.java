package com.suranjan.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.suranjan.security.User;

public class CustomUserDetails implements UserDetails{

private AdminSignupData adminSignupData;
	
	public CustomUserDetails(AdminSignupData adminSignupData) {
		this.adminSignupData = adminSignupData;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(adminSignupData.getEmail());
		
		return List.of(simpleGrantedAuthority);
	}

	@Override
	public String getPassword() {
		
		return adminSignupData.getPassword();
	}

	@Override
	public String getUsername() {
	
		return adminSignupData.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}
}
