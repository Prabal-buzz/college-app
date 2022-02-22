package com.college;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.college.controller.FeeController;
import com.college.controller.PaymentController;

import seed.SeederFile;
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		new File(FeeController.uploadDirectory).mkdir();
		new File(PaymentController.uploadDirectory).mkdir();
		
		SpringApplication.run(Application.class, args);
		
		
	}

}
