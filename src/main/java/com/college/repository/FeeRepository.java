package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Fee;

public interface FeeRepository extends JpaRepository<Fee,Integer> {

}
