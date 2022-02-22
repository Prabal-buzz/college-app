package com.college.service;

import java.util.List;

import com.college.model.Payment;

public interface PaymentService {
	
	public Payment savePayment(Payment payment);
	List<Payment> getAllPaymentByFeeId(Integer id);
	List<Payment> getAllPaymentByFeeIdAndSemester(Integer id,Integer semester);

}
