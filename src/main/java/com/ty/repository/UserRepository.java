package com.ty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailAndPassword(String email, String password);

	User findByPhoneAndPassword(Long phone, String password);
}
