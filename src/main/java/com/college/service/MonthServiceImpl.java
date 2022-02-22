package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Month;
import com.college.repository.MonthRepository;

@Service
public class MonthServiceImpl implements MonthService {
   @Autowired
   private MonthRepository monthRepository;
	
	@Override
	public List<Month> showAllMonth() {
		return monthRepository.findAll();
	}

	@Override
	public void saveMonth(Month month) {

      monthRepository.save(month);
		
	}

	@Override
	public Integer countMonth() {
		return (int) monthRepository.count();
	}

	@Override
	public Month getMonthById(Integer id) {
		return monthRepository.findById(id).get();
	}

}
