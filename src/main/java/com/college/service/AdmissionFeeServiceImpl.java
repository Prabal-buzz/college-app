package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.AdmissionFee;
import com.college.repository.AdmissionFeeRepository;

@Service
public class AdmissionFeeServiceImpl implements AdmissionFeeService {
	
	@Autowired
	private AdmissionFeeRepository admissionFeeRepo;

	@Override
	public void saveAdmissionFee(AdmissionFee admissionFee) {
	  admissionFeeRepo.save(admissionFee);
		
	}

	@Override
	public List<AdmissionFee> getAllAdmissionFee() {
		return admissionFeeRepo.findAll();
	}

	@Override
	public AdmissionFee getAdmissionFeeById(Integer id) {
		
		return admissionFeeRepo.getById(id);
	}

}
