package com.ty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.dao.UserDao;
import com.ty.dto.LoginResponse;
import com.ty.dto.UserRequest;
import com.ty.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	public String signUp(User user) {
		User rUser = userDao.getByPhone(user.getPhone());

		if (rUser == null) {
			userDao.signUp(user);
			return "User registered successfully";
		} else {
			return "Phone number already registerd";
		}
	}

	public ResponseEntity<LoginResponse> login(UserRequest request) {
		User byEmailAndPassword = userDao.findByEmailAndPassword(request.getEmail(), request.getPassword());
		User byPhoneAndPassword = userDao.findByPhoneAndPassword(request.getPhoneNo(), request.getPassword());

		LoginResponse loginResponse = new LoginResponse();
		if (byEmailAndPassword != null) {
			loginResponse.setMessage("Success");
			loginResponse.setUser(byEmailAndPassword);
			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
		} else if (byPhoneAndPassword != null) {
			loginResponse.setMessage("Success");
			loginResponse.setUser(byPhoneAndPassword);
			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
		} else {
			loginResponse.setMessage("Not Found");
			loginResponse.setUser(null);
			return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.NOT_FOUND);
		}
	}
}
