package com.college.service;

import java.util.List;

import com.college.model.Year;

public interface YearService {

	public List<Year> getYear();
	public Year getById(Integer id);
	public void  saveYear(Year year);
	public void setAllIsCalender(boolean isCalender,Integer id);
	public boolean checkIfDeleteble(Integer id);
	public void deleteProgram(Integer id);
	public Year  findYearByName(String name);
	public Year  findYearByIsCalender();
}
