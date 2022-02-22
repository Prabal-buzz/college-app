package com.college.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.college.model.NewsAndAnnouncement;
import com.college.service.NewsAndAnnouncementService;

@Controller
public class NewsAndAnnouncementControllerUser {
	@Autowired 
	  private NewsAndAnnouncementService newsAndAnnouncementService;

	@GetMapping("/newsAndAnnouncement")
	public String newsAndAnnouncementShow(Model model) {
		String active="news";
		List<NewsAndAnnouncement> listOfNewsAndAnnouncements=newsAndAnnouncementService.getAllNewsAndAnnouncement();
	
		model.addAttribute("listOfNewsAndAnnouncements",listOfNewsAndAnnouncements);
	    model.addAttribute("active",active);
		
		return "front/news_and_announcement";
	}
	
}
