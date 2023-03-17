package com.suranjan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suranjan.security.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	

		public Optional<User> findByUserName(String username);
	 
		public Optional<User> findByEmail(String email) ;
}
