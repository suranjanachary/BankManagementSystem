package com.suranjan.model;

import org.springframework.data.domain.Sort;

import com.suranjan.dto.CustomerDetailsDTO;

public class CustomerPage {
	
	private int pageNumber = 0;
	
	private int pageSize = 2 ;
	
	private Sort.Direction sortDirection = Sort.Direction.ASC;
	
	private String sortBy = "customerName";
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Sort.Direction getSortDirection() {
		return sortDirection;
	}
	public void setSortDirection(Sort.Direction sortDirection) {
		this.sortDirection = sortDirection;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	
}
