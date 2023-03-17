package com.suranjan.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suranjan.model.AdminSignupData;
import com.suranjan.model.LoginForm;
import com.suranjan.repository.AdminSignupDao;

@RestController
public class LoginController {
	
	
	@Autowired
	private AdminSignupDao adminSignupDao;
	
//
//	 @Autowired
//	 private AuthenticationManager authenticationManager;
//	 
//	 @PostMapping("/login")
//	 public ResponseEntity login(@RequestBody LoginForm loginRequest, 
//	 HttpServletResponse response,
//	 HttpServletRequest request) {
//	 try {
//	 System.out.println(loginRequest);
//	 org.springframework.security.core.Authentication 
//	 authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken
//			 (loginRequest.getUserName(), loginRequest.getPassword()));
//	 
//	 SecurityContextHolder.getContext().setAuthentication(authentication);
//	 
//	 Cookie sessionCookie = new Cookie("JSESSIONID", request.getSession().getId());
//	 
//	 response.addCookie(sessionCookie);
//	 return new ResponseEntity(sessionCookie,HttpStatus.OK);
//	 
//	    } 	catch (AuthenticationException ex) {
//			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//		        }
//	 }

	@GetMapping("/signin")
	public ResponseEntity<AdminSignupData> getLoggedInCustomerDetailsHandler (Authentication auth){
		
		System.out.println(auth);
		
		AdminSignupData adminSignupData = adminSignupDao.findByEmail(auth.getName()).orElseThrow(
				()-> new BadCredentialsException("No Users found with this given user name"));
		
		return new ResponseEntity<>(adminSignupData,HttpStatus.ACCEPTED);
	}

}
