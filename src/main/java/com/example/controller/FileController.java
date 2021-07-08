package com.example.controller;

import java.nio.file.Path;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.CreateFileLog;
import com.example.models.CreateFileRequest;
import com.example.services.CreateFileService;
import com.example.services.LogRepository;

@RestController
@RequestMapping(value = "/docker")
public class FileController {
	
	@Autowired
	LogRepository repository;
	
	@PostMapping("/storage/createFile")
	public ResponseEntity<Path> createFileService(@RequestBody CreateFileRequest file,HttpServletRequest req){
				
		Path p=CreateFileService.createFile(file);
		
		repository.save(new CreateFileLog(file.getFileName(),req.getLocalAddr()));
		
		return new ResponseEntity<>(p,HttpStatus.OK);
	}
	
	@GetMapping("/storage/{fileName}")
	public ResponseEntity<String> featchFileService(@PathVariable String fileName){
		List<String> content = CreateFileService.getDetails(fileName);
		return new ResponseEntity<String>(content.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/logs")
	public ResponseEntity<String> featchLogs(){
		
		List<CreateFileLog> list = repository.findAll();

		return new ResponseEntity<>(list.toString(),HttpStatus.OK);
	}
	
	

}
