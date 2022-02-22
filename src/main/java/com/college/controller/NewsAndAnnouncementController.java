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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.model.NewsAndAnnouncement;
import com.college.service.NewsAndAnnouncementService;

@Controller
@RequestMapping("/admin/newAndAnnouncement")
public class NewsAndAnnouncementController {
	  private	long millis=System.currentTimeMillis();  
	  private   Date date=new Date(millis);
	  
	  @Autowired 
	  private NewsAndAnnouncementService newsAndAnnouncementService;

	@GetMapping("")
	public String showNewsAndAnnouncementTable(Model model) {
		 List<NewsAndAnnouncement> listOfNewsAndAnnouncements=newsAndAnnouncementService.getAllNewsAndAnnouncement();
		String news_link="active";
		model.addAttribute("news_link",news_link);
		
	    model.addAttribute("listOfNewsAndAnnouncements",listOfNewsAndAnnouncements);
		return "admin/news_and_announcement_table";
		
	}
	
	@GetMapping("/form")
	public String showNewsAndAnnouncementForm(Model model) {
		String news_link="active";
	    model.addAttribute("news_link",news_link);
	    model.addAttribute("newsAndAnnouncement",new NewsAndAnnouncement());
		return "admin/news_and_announcement_form";
	}
	
	@PostMapping("/save")
	public String saveNewsAndAnnouncement(NewsAndAnnouncement newsAndAnnouncement,RedirectAttributes redirAttr) {
		
		if(newsAndAnnouncement.getId()!=null) {
			redirAttr.addFlashAttribute("success","news and announcement has been updated successfully");
			newsAndAnnouncement.setUpdatedAt(date);
		}else {
			redirAttr.addFlashAttribute("success","news and announcement has been set successfully");
			newsAndAnnouncement.setCreatedAt(date);
		}
		
		newsAndAnnouncementService.saveNewsAndAnnouncement(newsAndAnnouncement);
		return "redirect:/admin/newAndAnnouncement";
	}
	
	@GetMapping("/update/{id}")
	public String updateNewsAndAnnouncement(@PathVariable(name="id")Integer id,Model model ) {
		NewsAndAnnouncement newsAndAnnouncement=newsAndAnnouncementService.getNewsAndAnnouncementById(id);
	
		String news_link="active";
	    model.addAttribute("news_link",news_link);
	    model.addAttribute("newsAndAnnouncement",newsAndAnnouncement);
		return "admin/news_and_announcement_form";
	}
	
	
	@GetMapping("/delete/{id}")
    public String deleteNewsAndAnnouncement(@PathVariable(name="id")Integer id ,RedirectAttributes redirAttr ) {
		newsAndAnnouncementService.deleteNewsAndAnnouncementById(id);
		redirAttr.addFlashAttribute("success","news and announcement has been deleted successfully");
		return "redirect:/admin/newAndAnnouncement";
	}
	
}
