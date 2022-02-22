package com.college.service;

import com.college.model.Fee;

public interface FeeService {
	
	public Fee saveFee(Fee fee);
	public Fee getFeeById(Integer id);
	public int getSemesterFee(int feeid,int semester);

}
