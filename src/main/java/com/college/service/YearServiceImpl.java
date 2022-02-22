package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Year;
import com.college.repository.YearRepository;

@Service
public class YearServiceImpl implements YearService {
	@Autowired 
	  private YearRepository yearRepo;
	@Autowired 
	  private StudentService studentService;
	@Override
	public List<Year> getYear() {
		return this.yearRepo.findAll();
	}
	
	@Override
	public Year getById(Integer id) {
	return this.yearRepo.getById(id);
	}

	@Override
	public void saveYear(Year year) {
		 this.yearRepo.save(year);	
	}

	@Override
	public void setAllIsCalender(boolean isCalender,Integer id) {
		this.yearRepo.setAllIsCalender(isCalender,id);
		
	}

	@Override
	public boolean checkIfDeleteble(Integer id) {
		if(studentService.fetchStudentByRegistrationYear(id).isEmpty()) {
			return true;
		}else {
			return false;	
		}
		
	}

	@Override
	public void deleteProgram(Integer id) {
		this.yearRepo.deleteById(id);
		
	}

	@Override
	public Year findYearByName(String name) {
		
		return this.yearRepo.findYearByName(name);
	}

	@Override
	public Year findYearByIsCalender() {
		
		return yearRepo.findYearByIsCalender();
	}

}
