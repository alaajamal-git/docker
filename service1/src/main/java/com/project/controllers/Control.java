package com.project.controllers;

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
	
	@PostMapping("/add")
	public ResponseEntity<String> response(@RequestBody String temp) {
		return new ResponseEntity<String>("Working",HttpStatus.ACCEPTED);
	}
	
	

}
