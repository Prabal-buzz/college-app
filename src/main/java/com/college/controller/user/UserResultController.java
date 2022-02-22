package com.college.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.model.Program;
import com.college.model.Result;
import com.college.model.ResultCategory;
import com.college.model.Student;
import com.college.service.ProgramService;
import com.college.service.ResultService;
import com.college.service.StudentService;

@Controller
public class UserResultController {
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ResultService resultService;
	@Autowired
	private StudentService studentService;
	@GetMapping("/result")
	public String showResult(Model model) {
		String active="result";
		model.addAttribute("active",active);
		List<Program> programList=programService.showAllProgram();
		model.addAttribute("programList",programList);
//		System.out.println(resultService.findResultByCategorySymbolStudent(1, "343256", 1));
		
		
		return "front/result";
	}
	@PostMapping("/result/check")
	public String checkResult(HttpServletRequest request,Model model,RedirectAttributes redir) {
		
		Map<String,Result> studentResult = new HashMap<String,Result>();
		String email=request.getParameter("email");
		String symbolno=request.getParameter("symbolno");
		String program=request.getParameter("program");
		String semester=request.getParameter("semester");
		String term=request.getParameter("term");
	    String showResult="yes";
	    Student student=studentService.getStudentByEmail(email);
		System.out.println("program="+program+"semester="+semester+"email="+email+"term="+term+"symbol="+symbolno+"sf");
	    List<ResultCategory>resultCategoriesList=resultService.findResultCategoryByProgramSemesterTerm(Integer.parseInt(program),Integer.parseInt(semester), Integer.parseInt(term));
        for(ResultCategory resultCategory:resultCategoriesList) {
        	studentResult.put(resultCategory.getSubject(), resultService.findResultByCategorySymbolStudent(resultCategory.getId(),symbolno, student.getId()));
        	
        }
        for (Map.Entry<String,Result> entry : studentResult.entrySet()) {
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());
    }
       
        redir.addFlashAttribute("studentResult",studentResult);
	    redir.addFlashAttribute("student",student);
	    if(!studentResult.isEmpty()) {
	    	 redir.addFlashAttribute("showResult",showResult);
	    }
	    
	    redir.addFlashAttribute("semester",semester);
	    redir.addFlashAttribute("term",term);
	   redir.addFlashAttribute("symbolno",symbolno);
	 
	   return "redirect:/result";
	}

}
