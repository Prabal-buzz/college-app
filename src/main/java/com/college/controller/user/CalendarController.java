package com.college.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.college.model.GroupOfDateEventMonth;
import com.college.model.GroupOfEventDetailDayBar;
import com.college.model.Month;
import com.college.nepalidateconverter.Converter;
import com.college.nepalidateconverter.NepaliDate;
import com.college.service.CalendarEventService;
import com.college.service.CalendarTitleService;
import com.college.service.MonthService;

@Controller
public class CalendarController {
	@Autowired
	private MonthService monthService;
	
	@Autowired
	private CalendarTitleService calendarTitleService;
	
	@Autowired
	private CalendarEventService calendarEventService;

	@GetMapping("/calendar")
	public String  showCalendar(Model model,HttpServletRequest request) {
		String active="calendar";
		List<Month> monthList=monthService.showAllMonth();
	    Converter converter=new Converter();
	    int month;
	    int  currentSal;
	    
	   try {
		   month= Integer.parseInt(request.getParameter("mahina"));
		   currentSal= Integer.parseInt(request.getParameter("saal"));
		   if(month>12 || month<1) {
			   throw(new Exception());
		   }
		   if(currentSal>2090 || currentSal<2010) {
			   throw(new Exception());
		   }
		   
	   }catch(Exception e) {
		   
		   month=converter.getCurrentNepliMonth();
		   currentSal=converter.getCurrentNepliYear();
	   }
	   
       int noOfDay=converter.getNepaliMonthFromYear(currentSal, month);
       int firstDayBar=converter.getBar(currentSal, month, 1);
       int lastDayBar=converter.getBar(currentSal, month, noOfDay);
       
       model.addAttribute("currentSal", currentSal);
       model.addAttribute("currentMahina", month);
		model.addAttribute("monthList",monthList);
		model.addAttribute("noOfDay",noOfDay);
		model.addAttribute("firstDayBar",firstDayBar);
		model.addAttribute("lastDayBar",lastDayBar);
		model.addAttribute("towMontNameWithYear",calendarEventService.getTwoEnglishMonthNameFromNepaliDate(currentSal,month));
		model.addAttribute("monthInNepali",calendarEventService.getMonthInNepli(month));
		model.addAttribute("listGroupOfDateEventMonth",calendarEventService.getAllCalendarDataWithTitle(currentSal, month, noOfDay));
     	model.addAttribute("listGroupOfEventDetailDayBar",calendarEventService.getAllCalendarDataWithDetail(currentSal, month, noOfDay));
		model.addAttribute("active",active);
     	for(GroupOfEventDetailDayBar li:calendarEventService.getAllCalendarDataWithDetail(currentSal, month, noOfDay)) {
     		System.out.println(li);
     	}
     	
		return "front/calendar";
	}
	
}
