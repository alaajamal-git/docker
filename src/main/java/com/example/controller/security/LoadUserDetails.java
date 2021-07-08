package com.example.controller.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.models.UserEntity;
import com.example.services.UserRepository;

@Service
public class LoadUserDetails implements UserDetailsService{

	@Autowired
	UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserEntity user = repository.findByEmail(username);
		System.out.println(user);
		if(user==null) throw new UsernameNotFoundException("Error sign up first");
		return new User(user.getEmail(), user.getPassword(),true,true,true,true,new ArrayList<>());

	}

}
