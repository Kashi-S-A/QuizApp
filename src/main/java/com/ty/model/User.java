package com.ty.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_info")
public class User {

	@Id
	private long phone;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

}
