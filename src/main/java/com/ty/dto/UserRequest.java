package com.ty.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
	private String email;
	private Long phoneNo;
	private String password;
}
