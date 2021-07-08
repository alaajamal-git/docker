package com.example.services;

import org.springframework.data.repository.CrudRepository;

import com.example.models.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{

	UserEntity findByEmail(String email);
	
}
