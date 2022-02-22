package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.college.model.Program;
import com.college.model.Student;
import com.college.repository.ProgramRepository;

@Service
public class ProgramServiceImpl implements ProgramService {
	
    @Autowired
	private ProgramRepository programRepository;
	
    @Autowired
    private StudentService studentService;
    
	@Override
	public Program saveProgram(Program program) {
	 return this.programRepository.save(program);
	  
	 
	}

	@Override
	public List<Program> showAllProgram() {
		// TODO Auto-generated method stub
		return programRepository.findAll();
	}

	@Override
	public Program programFindById(Integer id) {
		return programRepository.findById(id).get();
	}

	@Override
	public void deleteProgram(Integer id) {
		this.programRepository.deleteById(id);;
		
	}


	@Override
	public String validaeForm(Program program, RedirectAttributes redirAttrs) {
		if(program.getName().length()>5) {
			redirAttrs.addFlashAttribute("success","name must be lessthan 5");
			return "redirect:/program-form";
					
		}
		return null;
		
		
	}

	@Override
	public Program fetchProgramFromName(String name) {
		  return this.programRepository.getProgramByName(name);
	}

	@Override
	public boolean checkIfDeleteble(Integer id) {
		List<Student> listOfStudent= studentService.fetchStudentByProgram(id);
		if(listOfStudent.isEmpty()) {
			return true;	
		}else {
			return false;
		}
		
	}	

}
