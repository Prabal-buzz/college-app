package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.AdmissionFee;
import com.college.model.SecurityFee;

public interface SecurityFeeRepository extends JpaRepository<SecurityFee, Integer> {

}
