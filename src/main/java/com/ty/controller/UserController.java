package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.dto.LoginResponse;
import com.ty.dto.UserRequest;
import com.ty.model.User;
import com.ty.service.UserService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5501")
@RequestMapping("/quiz/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public String signUp(@RequestBody User user) {
		return userService.signUp(user);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> postMethodName(@RequestBody UserRequest userRequest) {
		return userService.login(userRequest);
	}

}
