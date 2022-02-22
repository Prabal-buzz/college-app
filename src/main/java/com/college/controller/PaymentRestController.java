package com.college.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.college.model.Program;

@RestController
public class PaymentRestController {
	

	 @PostMapping("/x")
	  Program newEmployee(@RequestBody Program p) {
	    return p ;
	  }

}
