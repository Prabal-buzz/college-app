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

import com.college.model.AdmissionFee;
import com.college.model.Program;
import com.college.service.AdmissionFeeService;
import com.college.service.ProgramService;

@Controller
@RequestMapping("/admin")
public class AdmissionFeeController {
	  private	long millis=System.currentTimeMillis();  
	  private   Date date=new Date(millis); 
	    
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private AdmissionFeeService admissionFeeService;
	
@GetMapping("/admisssion-fee")
public String showAdmissionFee(Model model) {
   String fee_link="active";
   List<AdmissionFee> admissionFeeLists=admissionFeeService.getAllAdmissionFee();
   model.addAttribute("fee_link",fee_link);
	model.addAttribute("admissionFeeLists",admissionFeeLists);
	return "admin/admission_fee_table";
}

@GetMapping("/admission/fee-form")
public String admissionFeeFormShow(Model model) {
	
  List<Program> progarmList=programService.showAllProgram(); 
  String fee_link="active";
 	model.addAttribute("fee_link",fee_link);
	model.addAttribute("programLists",progarmList);
	model.addAttribute("admission_fee",new AdmissionFee());
	return "admin/admission_fee_form";
}

@PostMapping("/admission/fee/save")
public String saveAdmissionFee(AdmissionFee admissionFee) {
	if(admissionFee.getId()==null) {
		admissionFee.setCreatedAt(date);
	}else {
		admissionFee.setUpdatedAt(date);
	}
	admissionFee.getProgram().setHasFee(true);
	this.admissionFeeService.saveAdmissionFee(admissionFee);
	
	return "redirect:/admin/admisssion-fee";
}
@GetMapping("/admission/fee/update/{id}")
public String admissionFeeUpdate(@PathVariable(value="id")Integer id,Model model) {

	   AdmissionFee admission=admissionFeeService.getAdmissionFeeById(id);
	   List<Program> progarmList=programService.showAllProgram(); 
	   String fee_link="active";
	 	model.addAttribute("fee_link",fee_link);
	 	
		model.addAttribute("programLists",progarmList);
		model.addAttribute("admission_fee",admission);
		return "admin/admission_fee_form";
}

}
