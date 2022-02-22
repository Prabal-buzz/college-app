package com.college.service;

import java.util.List;

import com.college.model.Result;
import com.college.model.ResultCategory;

public interface ResultService {
   public void saveResult(Result result);
   ResultCategory saveResultCategory(ResultCategory resultCategory);
   List<ResultCategory> showAllResultCategory();
   List<Result> showAllResult(Integer id);
   ResultCategory  findResultCategoryById(Integer id);
   void deleteResultCategory(Integer id);
   void  deleteMarks(Integer id);
   Result  findResultById(Integer id);
   public  Result findResultByCategorySymbolStudent(int category_id,String symbolNo,int id);
   public  List<ResultCategory> findResultCategoryByProgramSemesterTerm(int program_id,int semester,int term);
}
