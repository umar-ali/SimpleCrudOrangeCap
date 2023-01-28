package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUser() {
		List<User> user = new ArrayList<User>();
		userRepository.findAll().forEach(user1 -> user.add(user1));
		return user;
	}

	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	public User getUser(String loginId) {
		return userRepository.findByLoginId(loginId).get();
	}

	public void saveOrUpdate(User user) {
		userRepository.save(user);
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}

	public void update(User user, int userno) {
		userRepository.save(user);
	}
}
