package com.suranjan.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.suranjan.model.AdminSignupData;
import com.suranjan.model.CustomUserDetails;
import com.suranjan.model.Customer;
import com.suranjan.repository.AdminSignupDao;
import com.suranjan.repository.CustomerDao;
import com.suranjan.repository.UserRepository;
import com.suranjan.security.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	

	@Autowired
	private AdminSignupDao adminSignupDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<AdminSignupData> adminSignupData = this.adminSignupDao.findByEmail(username);
		
		if(adminSignupData.isEmpty()) {
		
			throw new UsernameNotFoundException("User not Found !!!");
		
	     }
		else {
			return new CustomUserDetails(adminSignupData.get());
		}
	
	}

}
