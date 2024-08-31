package com.ty.dto;

import com.ty.model.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponse {
	private String message;
	private User user;
	
}
