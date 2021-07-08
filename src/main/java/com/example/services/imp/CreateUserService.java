package com.example.services.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.models.UserEntity;
import com.example.services.UserRepository;

@Service
public class CreateUserService {
	
	private UserRepository repository;
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	public CreateUserService(UserRepository repository, BCryptPasswordEncoder encoder) {
		super();
		this.repository = repository;
		this.encoder = encoder;
	}
	
	public void create(String email, String password) {
		
		UserEntity user =new UserEntity();
		user.setEmail(email);
		user.setPassword(encoder.encode(password));
		repository.save(user);
		
		
	}
	
	
	
	

}
