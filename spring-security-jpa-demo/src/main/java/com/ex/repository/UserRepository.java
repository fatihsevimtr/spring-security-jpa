package com.ex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.models.UserEntitiy;

public interface UserRepository extends JpaRepository<UserEntitiy, Integer>{
	
	Optional<UserEntitiy> findByUsername(String username);
}
