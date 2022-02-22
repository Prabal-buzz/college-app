package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.college.model.SecurityFee;
import com.college.repository.SecurityFeeRepository;

@Service
public class SecurityFeeServiceImpl implements SecurityFeeService {
	
	@Autowired
	private SecurityFeeRepository securityFeeRepo;

	@Override
	public void saveSecurityFee(SecurityFee securityFee) {
		securityFeeRepo.save(securityFee);
		
	}

	@Override
	public List<SecurityFee> getAllSecurityFee() {
		return securityFeeRepo.findAll();
	}

	@Override
	public SecurityFee getSecurityFeeById(Integer id) {
		
		return securityFeeRepo.getById(id);
	}

}
