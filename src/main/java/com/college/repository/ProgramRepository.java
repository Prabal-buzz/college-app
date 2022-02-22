package com.college.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.college.model.Program;


public interface ProgramRepository extends JpaRepository<Program,Integer>{
	
	@Query("SELECT p FROM Program p where p.name= ?1 ")
	public Program getProgramByName(String name);

}
