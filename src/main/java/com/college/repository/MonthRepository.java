package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.Month;

public interface MonthRepository extends JpaRepository<Month,Integer> {

}
