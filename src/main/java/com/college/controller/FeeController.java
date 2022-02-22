package com.college.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.model.Fee;
import com.college.model.Program;
import com.college.model.Student;
import com.college.model.Year;
import com.college.service.FeeService;
import com.college.service.ProgramService;
import com.college.service.StudentService;
import com.college.service.YearService;

@Controller
@RequestMapping("/admin")
public class FeeController {
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/resources/static/admin/photo";
	private	long millis=System.currentTimeMillis();  
	private   Date date=new Date(millis); 
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private YearService yearService;
	
	@Autowired
	private FeeService feeService;
	
	@PostMapping("/fee/save")
	 public String saveFee(Fee fee,@RequestParam("agreement") MultipartFile agreement,@RequestParam("student_id") Integer id,HttpServletRequest request,RedirectAttributes redirAttrs) {
		 
	
		
		 Integer page =Integer.parseInt( request.getParameter("page"));
		   String sortDir=request.getParameter("sortDir");
		   String year=request.getParameter("year");
		   String program=request.getParameter("program");
		   String sortField=request.getParameter("sortField");
	       Student student=studentService.getStudentById(id);
	      fee.setCreatedAt(date);
		if(agreement.isEmpty()) {
		
		}else{
				String fileName = System.currentTimeMillis()
					+ agreement.getOriginalFilename().substring(agreement.getOriginalFilename().length() - 4);
			Path fileAndPath = Paths.get(uploadDirectory, fileName);
			try {
				Files.write(fileAndPath, agreement.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		fee.setDocument(fileName);
		
		 	
		}
		if(fee.getId()==null) {
			redirAttrs.addFlashAttribute("success","Fee has been added to the student record");
		}else {
			redirAttrs.addFlashAttribute("success","Fee has been updated to the student record ");
		}
		
		Fee currentFee=feeService.saveFee(fee);
		student.setFee(currentFee);
		studentService.saveStudent(student);		
	 return "redirect:/admin/fee/page/"+page+"?sortField="+sortField+"&sortDir="+sortDir+"&year="+year+"&program="+program;
		
		

		}
	
	
	@GetMapping("/fee")
	public  String getStudentList(Model model,HttpServletRequest response) {
		List<Program> listPrograms=programService.showAllProgram();
		List<Year> listYears=yearService.getYear();
		String fee_link="active";
		model.addAttribute("listprograms",listPrograms);
		model.addAttribute("listyears",listYears);
		model.addAttribute("fee_link",fee_link);
		return findPaginated(1,"firstName","asc",model,response);
	}
	
	@GetMapping("/fee/page/{pageNo}")
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
			 System.out.println("null");
			
				
		}else {
			
			 page =studentService.fetchStudentByYearAndProgram(pageNo, pageSize,"firstName","asc",Integer.parseInt(year),Integer.parseInt(program));
			 listStudents=page.getContent();
			 System.out.println("not null jit");
			 model.addAttribute("year_id",Integer.parseInt(year));
			 model.addAttribute("program_id",Integer.parseInt(program));
		}
		
		
		String fee_link="active";
		List<Program> listPrograms=programService.showAllProgram();
		List<Year> listYears=yearService.getYear();
		model.addAttribute("fee_link",fee_link);
		
		model.addAttribute("listprograms",listPrograms);
		model.addAttribute("listyears",listYears);
		model.addAttribute("currentPage",pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("listStudents",listStudents);
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir",sortDir);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("reverseSortDir",sortDir.equals("asc")?"desc":"asc");
		return "admin/fee_table";
	}
	
	@GetMapping("/fee/form/{id}")
	public String showFrom(@PathVariable(value="id") Integer id ,Model model,@RequestParam("page")int pageNo ,@RequestParam("sortField") String sortField,@RequestParam("sortDir") String sortDir,@RequestParam("year") String year_id,@RequestParam("program") String program_id ) {
	
	  
		Student student=studentService.getStudentById(id);
	    String fee_link="active";
	    model.addAttribute("pageNo",pageNo);
	    model.addAttribute("sortDir",sortDir);
	    model.addAttribute("sortField",sortField);
	    model.addAttribute("year_id",year_id);
	    model.addAttribute("fee_link",fee_link);
	    model.addAttribute("program_id",program_id);
	    if(student.getFee()==null) {
	    	model.addAttribute("student_id",id);
	    	model.addAttribute("fee",new Fee());
	 
	        model.addAttribute("student",student);
			return "admin/fee_form";
	    }else
	    {
	      Fee fee=feeService.getFeeById(student.getFee().getId());
	      model.addAttribute("student_id",id);
	        model.addAttribute("fee",fee);
	       
	        model.addAttribute("student",student);
			return "admin/fee_form";
	   }
	   
	}
	
	

}
