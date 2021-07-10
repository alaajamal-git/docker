package com.project.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/control")
public class Control {
	private final int id=(int)(Math.random()*20);
	@PostMapping("/add")
	public ResponseEntity<String> response(@RequestBody String temp,HttpServletResponse res) {
		
		return new ResponseEntity<String>("Working+ "+id,HttpStatus.ACCEPTED);
	}
	
	

}
