package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Result;
import com.college.model.Student;

public interface ResultRepository extends JpaRepository<Result, Integer> {
	@Query("SELECT r FROM Result r where r.resultCategory.id=?1")
	List<Result> showAllResult(Integer id);
	
	@Query("SELECT s FROM Result s where s.resultCategory.id=?1 and s.symbolNo=?2 and s.student.id=?3")
	public  Result findResultByCategorySymbolStudent(int category_id,String symbolNo,int id);
}
