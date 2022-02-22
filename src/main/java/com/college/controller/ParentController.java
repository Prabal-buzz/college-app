package com.college.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.college.model.Parent;
import com.college.model.Program;
import com.college.model.Student;
import com.college.model.Year;
import com.college.service.ParentService;
import com.college.service.ProgramService;
import com.college.service.StudentService;
import com.college.service.YearService;

@Controller
@RequestMapping("/admin/")
public class ParentController {
	  private	long millis=System.currentTimeMillis();  
	  private   Date date=new Date(millis); 
	    
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ParentService parentService;
	@Autowired
	private YearService yearService;

	
	@GetMapping("/parent")
	public String showParent(Model model,HttpServletRequest response) {
		
		return findPaginated(1,"firstName","asc",model,response);
		
	}
	
	@PostMapping("/parent/save")
	public String saveParent(Parent parent, @RequestParam("stu")String id, HttpServletRequest request) {
		   Integer page =Integer.parseInt( request.getParameter("page"));
		   String sortDir=request.getParameter("sortDir");
		   String year=request.getParameter("year");
		   String program=request.getParameter("programs");
		   String sortField=request.getParameter("sortField");
		Student student =studentService.getStudentById(Integer.parseInt(id));
		Parent getCurrentSavedParent=parentService.saveParent(parent);
		student.setParent(getCurrentSavedParent);
		this.studentService.saveStudent(student);
		  student.setParent(parent);
		  if(page==1){
		  return "redirect:/admin/parent";
		  }else {
			  return "redirect:/admin/parent/page/"+page+"?sortField="+sortField+"&sortDir="+sortDir+"&year="+year+"&program="+program;
		  }
		  
	}
	
	
	@GetMapping("/parent/update/{id}")
	public String updateParent(@PathVariable(name="id") Integer id,Model model,@RequestParam("sortField") String sortField,@RequestParam("page") int page,@RequestParam("sortDir") String sortDir,@RequestParam("year") String year,@RequestParam("program") String program) {
		String parent_link="active";
		Student student =studentService.getStudentById(id);
		
		
		if(student.getParent()==null) {
		
			    Parent parent=new Parent();
			    
			    model.addAttribute("parent_link",parent_link);
			    model.addAttribute("year",2020);
			    model.addAttribute("parent",parent);
				model.addAttribute("stu",id);
		}else {
			    
			    
			    model.addAttribute("parent_link",parent_link);
			    model.addAttribute("year",2020);
			    model.addAttribute("parent",student.getParent());
				model.addAttribute("stu",id);
			
		}
			
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("page",page);
		model.addAttribute("program",program);
		model.addAttribute("year",year);	
		
		return "admin/parent_form";	
	}
	
	
	@GetMapping("/parent/page/{pageNo}")
	public String findPaginated(@PathVariable(value="pageNo")int pageNo ,@RequestParam("sortField") String sortField,@RequestParam("sortDir") String sortDir,Model model,HttpServletRequest response) {
		int pageSize=10;
	    List<Student> listStudents;
	    Page<Student> page;
		String year=response.getParameter("year");
		String program=response.getParameter("program");
		System.out.println(program);
		
		
		if(year==null|| program==null || program.equals("null") ) {
		
			 page=studentService.findPaginate(pageNo, pageSize,"firstName","asc");
			 listStudents=page.getContent();
			
				
		}else {
			
			 page =studentService.fetchStudentByYearAndProgram(pageNo, pageSize,"firstName","asc",Integer.parseInt(year),Integer.parseInt(program));
			 listStudents=page.getContent();
			 
			 model.addAttribute("year_id",Integer.parseInt(year));
			 model.addAttribute("program_id",Integer.parseInt(program));
		}
		
		
		String parent_link="active";
		
		List<Year> listYears=yearService.getYear();
		List<Program> listPrograms = programService.showAllProgram();
		model.addAttribute("listprograms",listPrograms);
		model.addAttribute("listyears",listYears);
		model.addAttribute("parent_link",parent_link);
		
		model.addAttribute("listPrograms",listPrograms);
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("listStudents",listStudents);
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");
		return "admin/parent";
	}
	
	@GetMapping("/parent/show/{id}")
	public String vewParentDetails(@PathVariable("id") Integer id,Model model) {
		Student stu=studentService.getStudentById(id);
		model.addAttribute("student",stu);
		return "admin/parent_view";
	}
	
	
}
