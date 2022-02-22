package com.college.service;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.college.model.Program;

public interface ProgramService {

	public Program saveProgram(Program faculty);
	public List<Program> showAllProgram();
	public Program  programFindById(Integer id);
	public void deleteProgram(Integer id);
	public String validaeForm(Program program,RedirectAttributes redirAttrs);
	public Program fetchProgramFromName(String name);
	public boolean checkIfDeleteble(Integer id);
    

}
