package com.college.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.college.model.Program;
import com.college.model.SecurityFee;

import com.college.service.ProgramService;
import com.college.service.SecurityFeeService;

@Controller
@RequestMapping("/admin")
public class SecurityFeeController {
	  private	long millis=System.currentTimeMillis();  
	  private   Date date=new Date(millis); 
	    
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private SecurityFeeService securityFeeService;
	
@GetMapping("/security-fee")
public String showSecurityFee(Model model) {
   String fee_link="active";
   List<SecurityFee> securityFeeLists=securityFeeService.getAllSecurityFee();
   model.addAttribute("fee_link",fee_link);
	model.addAttribute("securityFeeLists",securityFeeLists);
	return "admin/security_fee_table";
}

@GetMapping("/security/fee-form")
public String securityFeeFormShow(Model model) {
	
  List<Program> progarmList=programService.showAllProgram(); 
  String fee_link="active";
 	model.addAttribute("fee_link",fee_link);
	model.addAttribute("programLists",progarmList);
	model.addAttribute("security_fee",new SecurityFee());
	return "admin/security_fee_form";
}

@PostMapping("/security/fee/save")
public String saveSecurityFee(SecurityFee securityFee) {
	if(securityFee.getId()==null) {
		securityFee.setCreatedAt(date);
	}else {
		securityFee.setUpdatedAt(date);
	}
	securityFee.getProgram().setHasSecurity(true);
	this.securityFeeService.saveSecurityFee(securityFee);
	
	return "redirect:/admin/security-fee";
}
@GetMapping("/security/fee/update/{id}")
public String SecurityFeeUpdate(@PathVariable(value="id")Integer id,Model model) {

	   SecurityFee securityFee=securityFeeService.getSecurityFeeById(id);
	   List<Program> progarmList=programService.showAllProgram(); 
	   String fee_link="active";
	 	model.addAttribute("fee_link",fee_link);
	 	
		model.addAttribute("programLists",progarmList);
		model.addAttribute("security_fee",securityFee);
		return "admin/security_fee_form";
}

}
