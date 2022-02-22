package com.college.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {
	
	@RequestMapping("")
	public String homePage(Model model) {
		String active="home";
		model.addAttribute("active",active);
		return "front/index";
	}

}
