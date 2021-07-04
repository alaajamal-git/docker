package com.example.controller;

import java.nio.file.Path;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.CreateFileRequest;
import com.example.services.CreateFileService;

@RestController
@RequestMapping(value = "/docker")
public class MainController {
	
	@PostMapping("/storage/createFile")
	public ResponseEntity<Path> createFileService(@RequestBody CreateFileRequest req, Errors errors){
				
		Path p=CreateFileService.createFile(req);
		
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@GetMapping("/storage/{fileName}")
	public ResponseEntity<String> featchFileService(@PathVariable String fileName){
		List<String> content = CreateFileService.getDetails(fileName);
		return new ResponseEntity<String>(content.toString()+" last!",HttpStatus.OK);
	}
	
	

}
