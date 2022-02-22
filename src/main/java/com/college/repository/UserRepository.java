package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.college.model.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	@Query("SELECT s FROM User s where s.email= ?1")
	public User getUsertByEmail(String email);
	
	
}
