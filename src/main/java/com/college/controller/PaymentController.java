package com.college.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.college.model.Fee;
import com.college.model.Payment;
import com.college.model.Student;
import com.college.service.AdmissionFeeService;
import com.college.service.FeeService;
import com.college.service.PaymentService;
import com.college.service.SecurityFeeService;
import com.college.service.StudentService;

@Controller
@RequestMapping("/admin/payment/")
public class PaymentController {
	
	
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/resources/static/admin/voucher";	
	@Autowired
	private FeeService feeService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AdmissionFeeService admissionFeeService;
	
	@Autowired
	private SecurityFeeService securityFeeService;
	
	@Autowired
	private PaymentService paymentService;
	
	private	long millis=System.currentTimeMillis();  
	private   Date date=new Date(millis); 
	
	@GetMapping("/{id}")
	public String viewPaymentForm(@PathVariable(name="id") Integer id,Model model) {
		String fee_link="active";
		
		Student student=studentService.getStudentById(id);
		List<Payment> paymentlistsFirst=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),1);
		List<Payment> paymentlistsSecond=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),2);
		List<Payment> paymentlistsThird=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),3);
		List<Payment> paymentlistsFourth=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),4);
		List<Payment> paymentlistsSeventh=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),7);
		List<Payment> paymentlistsFifth=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),5);
		List<Payment> paymentlistsSixth=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),6);
		List<Payment> paymentlistsEighth=paymentService.getAllPaymentByFeeIdAndSemester(student.getFee().getId(),8);
		
		model.addAttribute("paymentlistsFirst",paymentlistsFirst);
		model.addAttribute("paymentlistsSecond",paymentlistsSecond);
		model.addAttribute("paymentlistsThird",paymentlistsThird);
		model.addAttribute("paymentlistsFourth",paymentlistsFourth);
		model.addAttribute("paymentlistsFifth",paymentlistsFifth);
		model.addAttribute("paymentlistsSixth",paymentlistsSixth);
		model.addAttribute("paymentlistsSeventh",paymentlistsSeventh);
		model.addAttribute("paymentlistsEighth",paymentlistsEighth);
		model.addAttribute("student",student);
		model.addAttribute("fee_link",fee_link);
		return "admin/payment";
	}
	
  @PostMapping("/save/type-voucher")
   @ResponseBody public Payment  savePaymentTypeVoucher(@RequestParam("file") MultipartFile file,@RequestParam("mode") String mode,@RequestParam("amount") Integer amount,@RequestParam("enteredBy") String enteredBy,@RequestParam("feeId") Integer feeId,@RequestParam("semester") Integer semester) {
	  Fee fee=feeService.getFeeById(feeId);
	  Payment payment=new Payment();
	  payment.setAmount(amount);
	  payment.setFee(fee);
	  payment.setCreatedAt(date);
	  payment.setMode(mode);
	  payment.setSemester(semester);
	  payment.setUser(null);
	  
	  
	  
	  if(file.isEmpty()) {
			
		}else{
				String fileName = System.currentTimeMillis()
					+ file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
			Path fileAndPath = Paths.get(uploadDirectory, fileName);
			try {
				Files.write(fileAndPath, file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		payment.setVoucher(fileName);
		
		 	
		}
	  Payment payReturn= paymentService.savePayment(payment);
		 Payment paymentResponse=new Payment();
		     paymentResponse.setAmount(payReturn.getAmount());
		     paymentResponse.setCreatedAt(payReturn.getCreatedAt());
		     paymentResponse.setMode(payReturn.getMode());
		      return paymentResponse ;
		 
	 
  }
  
  @GetMapping("/save/type-cash")
  @ResponseBody public Payment  savePaymentTypeCash(@RequestParam("mode") String mode,@RequestParam("amount") Integer amount,@RequestParam("enteredBy") String enteredBy,@RequestParam("feeId") Integer feeId,@RequestParam("semester") Integer semester) {
	
	
	  Fee fee=feeService.getFeeById(feeId);
	  Payment payment=new Payment();
	  payment.setAmount(amount);
	  payment.setFee(fee);
	  payment.setCreatedAt(date);
	  payment.setMode(mode);
	  payment.setSemester(semester);
	  payment.setUser(null);
	  
	  Payment payReturn= paymentService.savePayment(payment);
	 Payment paymentResponse=new Payment();
	     paymentResponse.setAmount(payReturn.getAmount());
	     paymentResponse.setCreatedAt(payReturn.getCreatedAt());
	     paymentResponse.setMode(payReturn.getMode());
	     
	  
	 
			  return paymentResponse ;
	
	 
 }
  
  
 
  
  @GetMapping("/bill/{id}")
  public String getBill(@PathVariable("id") Integer id,@RequestParam("semester") Integer semester,Model model ) {
	  
	  List<Payment> listOfPayment=paymentService.getAllPaymentByFeeId(id);
	  Fee fee=feeService.getFeeById(id);
	  List<Payment> listOfPaymentWithSpecificSemester=new ArrayList<>();
	  for(Payment p :listOfPayment) {
		  if(p.getSemester()==(semester)) {
		
				  
			  listOfPaymentWithSpecificSemester.add(p);
			  
		  }
	  }
	  if(semester==1)
	  {
		  model.addAttribute("semAmount",fee.getSemesterFirst()*(0.6));
		model.addAttribute("tuAmount",(fee.getSemesterFirst())*(0.4));
	  }
	  if(semester==2)
	  {
		  model.addAttribute("semAmount",fee.getSemesterSecond()*0.6);
		model.addAttribute("tuAmount",fee.getSemesterSecond()*0.4);
	  }
	  if(semester==3)
	  {
		  model.addAttribute("semAmount",fee.getSemesterThird()*0.6);
		model.addAttribute("tuAmount",fee.getSemesterThird()*0.4);
	  }
	  if(semester==4)
	  {
		  model.addAttribute("semAmount",fee.getSemesterFourth()*0.6);
		model.addAttribute("tuAmount",fee.getSemesterFourth()*0.4);
	  }
	  if(semester==5)
	  {
		  model.addAttribute("semAmount",fee.getSemesterFifth()*0.6);
		model.addAttribute("tuAmount",fee.getSemesterFifth()*0.4);
	  }
	  if(semester==6)
	  {
		  model.addAttribute("semAmount",fee.getSemesterSixth()*0.6);
		model.addAttribute("tuAmount",fee.getSemesterSixth()*0.4);
	  }
	  if(semester==7)
	  {
		  model.addAttribute("semAmount",fee.getSemesterSeventh()*0.6);
		model.addAttribute("tuAmount",fee.getSemesterSeventh()*0.4);
	  }
	  if(semester==8)
	  {
		  model.addAttribute("semAmount",fee.getSemesterEight()*0.6);
		model.addAttribute("tuAmount",fee.getSemesterEight()*0.4);
	  }
	  System.out.println(listOfPayment);
	  System.out.println(listOfPaymentWithSpecificSemester);
	  model.addAttribute("listOfPaymentWithSpecificSemester",listOfPaymentWithSpecificSemester);
	  model.addAttribute("fee",fee);
	  model.addAttribute("date",date);
	  model.addAttribute("semester",semester);
	  return "admin/bill";
  } 
  

}
