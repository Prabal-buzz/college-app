package com.college.service;

import java.util.List;

import com.college.model.AdmissionFee;

public interface AdmissionFeeService {
	
	public void saveAdmissionFee(AdmissionFee admissionFee);
	public List<AdmissionFee> getAllAdmissionFee();
	public AdmissionFee getAdmissionFeeById(Integer id);

}
