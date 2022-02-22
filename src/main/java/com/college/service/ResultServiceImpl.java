package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Result;
import com.college.model.ResultCategory;
import com.college.repository.ResultCategoryRepository;
import com.college.repository.ResultRepository;

@Service
public class ResultServiceImpl implements ResultService {
	
	@Autowired 
	private ResultRepository resultRepository;
   @Autowired
   private ResultCategoryRepository resultCategoryRepository;

	@Override
	public void saveResult(Result result) {
		resultRepository.save(result);
		
	}

	@Override
	public ResultCategory saveResultCategory(ResultCategory resultCategory) {
		
		return this.resultCategoryRepository.save(resultCategory);
	}

	@Override
	public List<ResultCategory> showAllResultCategory() {
		return resultCategoryRepository.findAll();
	}

	@Override
	public List<Result> showAllResult(Integer id) {
		
		return resultRepository.showAllResult(id);
	}

	@Override
	public ResultCategory findResultCategoryById(Integer id) {
		
		return resultCategoryRepository.getById(id);
	}

	@Override
	public void deleteResultCategory(Integer id) {
		resultCategoryRepository.deleteById(id);	
		
	}

	@Override
	public void deleteMarks(Integer id) {
		resultRepository.deleteById(id);
		
	}

	@Override
	public Result findResultById(Integer id) {
		
		return  resultRepository.findById(id).get();
	}

	@Override
	public Result findResultByCategorySymbolStudent(int category_id, String symbolNo, int id) {
		
		return  resultRepository.findResultByCategorySymbolStudent(category_id, symbolNo, id);
	}

	@Override
	public List<ResultCategory> findResultCategoryByProgramSemesterTerm(int program_id, int semester, int term) {
		
		return resultCategoryRepository.findResultCategoryByProgramSemesterTerm(program_id, semester, term);
	}
	

}
