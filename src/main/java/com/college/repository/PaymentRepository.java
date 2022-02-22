package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
	
	@Query("SELECT p FROM Payment p where p.fee.id=?1")
	List<Payment> fetchAllPaymentByFeeId(Integer id);
   
	@Query("SELECT p FROM Payment p where p.fee.id=?1 and p.semester=?2 ")
	List<Payment> fetchAllPaymentByFeeIdAndSemester(Integer id,Integer semester);
}
