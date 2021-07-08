package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.models.UserEntity;
import com.example.services.imp.CreateUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	CreateUserService createService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserEntity user) {
		createService.create(user.getEmail(), user.getPassword());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> signin(@RequestBody UserEntity user) {
		createService.create(user.getEmail(), user.getPassword());
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
