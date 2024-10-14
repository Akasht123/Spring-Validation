package com.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.practice.dao.UserRepository;
import com.practice.entity.User;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repository.getUserByName(username);
		
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}



}
