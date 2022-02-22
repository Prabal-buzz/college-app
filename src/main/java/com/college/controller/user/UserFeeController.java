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

import com.college.model.Payment;
import com.college.model.Student;
import com.college.service.AdmissionFeeService;
import com.college.service.FeeService;
import com.college.service.PaymentService;
import com.college.service.SecurityFeeService;
import com.college.service.StudentService;

@Controller
public class UserFeeController {
	
	@Autowired 
	private StudentService studentService;
	
	@Autowired 
	private FeeService feeService;
	
	@Autowired 
	private SecurityFeeService securityFeeService;
	
	@Autowired 
	private AdmissionFeeService admissionFeeService;
	
	@Autowired 
	private PaymentService paymentService;
	@GetMapping("/fee")
	public String showFee(Model model) {
		String active="fee";
		model.addAttribute("active",active);
		return "front/fee";
				
	}
	
	@PostMapping("/result/find")
	public String findResult(Model model,HttpServletRequest req,RedirectAttributes redir) {
		  int semester;
		try {
			String email=req.getParameter("email");
			String password=req.getParameter("password");
			redir.addFlashAttribute("email",email);
			try {
				 semester=Integer.parseInt(req.getParameter("semester"));
				 redir.addFlashAttribute("semester",semester);
			}catch(Exception e) {
				redir.addFlashAttribute("sem_error","plz select the semester");
				return "redirect:/fee";
						
			}
			Student student =studentService.getStudentByEmail(email);
			if(student==null) {
				redir.addFlashAttribute("email_error","email didnot match");
				
				return "redirect:/fee";
			}
			if(!student.getPassword().equals(password))  {
				redir.addFlashAttribute("pw_error","password didnot match");
				return "redirect:/fee";
			}
			
			
		  Map<String ,Integer> mapOffee=new HashMap<>();
		  
		  mapOffee.put("semester "+semester, feeService.getSemesterFee(student.getFee().getId(), semester));
		  if(semester==1) {
			  mapOffee.put("Admission fee",student.getProgram().getAdmissionFee().getAmount());
			  mapOffee.put("security fee",student.getProgram().getSecurityFee().getAmount());
		  }
		  int totalPaid=0;
		  int totalDue=0;
		   List<Payment> listOfPayment=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(), semester);
		   if(!listOfPayment.isEmpty()) {
			  for(Payment p:listOfPayment) {
				  totalPaid+=p.getAmount();
			  }
			 
		   }
			   for (Map.Entry<String,Integer> entry : mapOffee.entrySet()) {
				   totalDue+=entry.getValue();
			   }
			   
		   
		   redir.addFlashAttribute("totalDue",totalDue);
		   redir.addFlashAttribute("totalPaid",totalPaid);
		  redir.addFlashAttribute("mapOffee",mapOffee);
		  redir.addFlashAttribute("show","true");
		}catch(Exception e) {
			redir.addFlashAttribute("error","!!oops something went wrong");
			return "redirect:/fee";
		}
		return "redirect:/fee";
		
	}

}
