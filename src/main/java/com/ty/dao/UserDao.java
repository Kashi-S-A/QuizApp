package com.ty.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.model.User;
import com.ty.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User getByPhone(Long phone) {
		return userRepository.findById(phone).orElse(null);
	}

	public User signUp(User user) {
		return userRepository.save(user);
	}

	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User findByPhoneAndPassword(Long phone, String password) {
		return userRepository.findByPhoneAndPassword(phone, password);
	}
}
