package com.college.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Fee;
import com.college.repository.FeeRepository;

@Service
public class FeeServiceImpl implements FeeService {

	private FeeRepository feeRepo;
	@Autowired
	public FeeServiceImpl(FeeRepository feeRepo) {
		this.feeRepo=feeRepo;
	}
	@Override
	public Fee saveFee(Fee fee) {
		 return this.feeRepo.save(fee);
	}
	@Override
	public Fee getFeeById(Integer id) {
		 return  feeRepo.getById(id);
	}
	@Override
	public int getSemesterFee(int feeid, int semester) {
		Fee fee=getFeeById(feeid);
		if(semester==1) {
			return fee.getSemesterFirst();
		}else if(semester==2) {
			return fee.getSemesterSecond();
		}else if(semester==3) {
			return fee.getSemesterThird();
		}else if(semester==4) {
			return fee.getSemesterFourth();
		}else if(semester==5) {
			return fee.getSemesterFifth();
		}else if(semester==6) {
			return fee.getSemesterSixth();
		}else if(semester==7) {
			return fee.getSemesterSeventh();
		}else  {
			return fee.getSemesterEight();
		}
		
		
		
	}

}
