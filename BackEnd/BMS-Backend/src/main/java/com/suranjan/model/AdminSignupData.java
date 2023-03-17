package com.suranjan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class AdminSignupData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer adminId;
	
	private String name;

	private String userName;

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@Column(unique=true)
	private String email;

	private String address;

	public AdminSignupData() {
		// TODO Auto-generated constructor stub
	}

	public AdminSignupData(Integer adminId, String name, String userName, String password, String email,
			String address) {
		super();
		this.adminId = adminId;
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AdminSignupData [adminId=" + adminId + ", name=" + name + ", userName=" + userName + ", password="
				+ password + ", email=" + email + ", address=" + address + "]";
	}
	
	

}
