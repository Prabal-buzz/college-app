package com.college.service;

import java.util.List;

import com.college.model.SecurityFee;

public interface SecurityFeeService {
	
	public void saveSecurityFee(SecurityFee securityFee);
	public List<SecurityFee> getAllSecurityFee();
	public SecurityFee getSecurityFeeById(Integer id);

}
