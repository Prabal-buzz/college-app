package com.college.service;

import java.util.List;

import com.college.model.Month;

public interface MonthService {

	public List<Month> showAllMonth();
	public void saveMonth(Month month);
	public Integer countMonth();
	public Month getMonthById(Integer id);
	
}
