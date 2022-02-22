package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.college.model.ResultCategory;

public interface ResultCategoryRepository extends JpaRepository<ResultCategory, Integer> {
	
	@Query("SELECT r FROM ResultCategory r where r.program.id=?1 and r.semester=?2 and r.term=?3")
	public  List<ResultCategory> findResultCategoryByProgramSemesterTerm(int program_id,int semester,int term);

}
