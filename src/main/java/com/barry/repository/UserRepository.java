package com.barry.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barry.model.User;

public interface UserRepository
  extends JpaRepository<User, Integer> {
	
}