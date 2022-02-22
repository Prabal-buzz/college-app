package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentRepository extends JpaRepository<Student,Integer> {

	@Query("SELECT s FROM Student s where s.registrationyear.id= ?1 and s.program.id=?2")
	public Page<Student> getStudentByYearAndProgram(Integer year_id,Integer program_id,Pageable pageable);
	
	@Query("SELECT s FROM Student s where s.contact=?1")
	public Student getStudentByContact(String contact);
	
	@Query("SELECT s FROM Student s where s.email=?1")
	public Student getStudentByEmail(String email);
	
	@Query("SELECT s FROM Student s where s.program.id=?1")
	 public List<Student> fetchStudentByProgram(Integer id);
	
	@Query("SELECT s FROM Student s where s.registrationyear.id=?1")
	 public List<Student> fetchStudentByRegistrationYear(Integer id);
	
}
