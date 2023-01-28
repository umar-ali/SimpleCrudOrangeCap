package com.example.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	Optional<User> findByLoginId(String loginId);
	
}
