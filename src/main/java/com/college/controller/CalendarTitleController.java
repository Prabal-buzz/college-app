package com.college.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.college.model.CalendarTitle;
import com.college.model.Month;
import com.college.nepalidateconverter.Converter;

import com.college.service.CalendarTitleService;

import com.college.service.MonthService;

import com.college.service.YearService;

@Controller
@RequestMapping("/admin/calendar/title")
public class CalendarTitleController {

	private long millis = System.currentTimeMillis();
	private Date date = new Date(millis);
	@Autowired
	private MonthService monthService;

	
	@Autowired
	private YearService yearService;

	

	@Autowired
	private CalendarTitleService calendarTitleService;

	

	@GetMapping("/form")
	public String showCalendarTitleForm(Model model,HttpServletRequest request) {
		Converter converter=new Converter();
		int day;
		int month_id;
		try {
			 day=Integer.parseInt(request.getParameter("day"));
			 month_id=Integer.parseInt(request.getParameter("month"));
			
		}catch(Exception e) {
			return "redirect:/admin/calender-event";
		}
		
	   int year=converter.getCurrentNepliYear();
		
	   
	   
	   
	   CalendarTitle calendarTitle;
	   try {
		  
		  
		   if(month_id>12 || month_id<1 || day>32) {
			   throw (new Exception());
		   }
		   
	    calendarTitle=calendarTitleService.findCalendarTitleByYearMonthDay(year, month_id, day);
	   }catch(Exception e) {
		   return "redirect:/admin/calender-event";
	   }
	   
	   if(calendarTitle==null) {
		   calendarTitle=new CalendarTitle();
		   calendarTitle.setDay(day);
		   calendarTitle.setYear(year);
	   }
		
		
		
		String calender_link = "active";
		model.addAttribute("calendarTitle", calendarTitle);
		model.addAttribute("calender_link", calender_link);
		model.addAttribute("day", day);
		model.addAttribute("month_id", month_id);
		return "admin/calender_title_form";
	}

	
	@PostMapping("/save")
	public String saveCalendarTitle(CalendarTitle calendarTitle,RedirectAttributes redirectAttr,HttpServletRequest request) {
	    int month_id=Integer.parseInt(request.getParameter("month_id"));
		Month month=monthService.getMonthById(month_id);
		calendarTitle.setMonth(month);
		calendarTitleService.saveCalendarTitle(calendarTitle);
		if(calendarTitle.getId()==null) {
			redirectAttr.addFlashAttribute("success","Event title has been added successfully");
		}else {
			redirectAttr.addFlashAttribute("success","Event title has been updated successfully");
		}
	  
       return "redirect:/admin/calender-event?month="+month_id;
	}
}
