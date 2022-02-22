package com.college.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Year;

public interface YearRepository extends JpaRepository<Year, Integer> {
	@Transactional
	@Modifying
	@Query("UPDATE  Year y SET y.isCalender=?1 where y.id NOT IN(?2) ")
	public void  setAllIsCalender(boolean isCalender,Integer id);
	
	@Query("SELECT y FROM Year y where y.name=?1")
	public Year  findYearByName(String name);
	
	@Query("SELECT y FROM Year y where y.isCalender=true")
	public Year  findYearByIsCalender();

}
