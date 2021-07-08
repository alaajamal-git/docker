package com.example.services;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.CreateFileLog;

public interface LogRepository extends MongoRepository<CreateFileLog, String>{
	
	List<CreateFileLog> findAll();


}
