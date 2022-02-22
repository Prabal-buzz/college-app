package com.college.controller;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.college.model.CalendarEvent;
import com.college.model.CalendarList;

import com.college.model.Month;

import com.college.model.Year;
import com.college.nepalidateconverter.Converter;
import com.college.nepalidateconverter.NepaliDate;
import com.college.service.CalendarEventService;

import com.college.service.CalendarTitleService;

import com.college.service.MonthService;

import com.college.service.YearService;


@Controller
@RequestMapping("/admin")
public class CalenderEventController {
	private	long millis=System.currentTimeMillis();  
	private   Date date=new Date(millis); 
	@Autowired
	private MonthService monthService;
	
	
	
	@Autowired
	private YearService yearService;
	
	
	
	@Autowired
	private CalendarEventService calendarEventService;
	
	@Autowired
	private CalendarTitleService calendarTitleService;
	
	
	@GetMapping("/calender-event")
	public String showCalenderEvent(Model model,HttpServletRequest response) {
		this.seedMonth();
		Converter converter=new Converter();
		
		int month=1;
		Map<Integer, List<CalendarEvent>> groupingEventByDay;
		Map<Integer, List<CalendarEvent>> groupingEventByDayAferSorting;
		List<CalendarEvent> allMonthEvent=new ArrayList<>();
	      try{
	    	   month=Integer.parseInt(response.getParameter("month"));
	    	   allMonthEvent=calendarEventService.getAllMonthEvent(month,converter.getCurrentNepliYear());
	      }catch(Exception e) {
	    	  allMonthEvent=calendarEventService.getAllMonthEvent(month,converter.getCurrentNepliYear());    	  
	      }
	   
		groupingEventByDay =  allMonthEvent.stream().collect(Collectors.groupingBy(CalendarEvent::getDay));
		groupingEventByDayAferSorting=groupingEventByDay
				.entrySet()
				.stream()
			    .sorted(Map.Entry.comparingByKey()) 			
			    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
			    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
						
		List<Month> listOfMonths=monthService.showAllMonth();
		model.addAttribute("calendarTitleService",calendarTitleService);
		model.addAttribute("selectedMonth",month);
		model.addAttribute("selectedYear",converter.getCurrentNepliYear());
		model.addAttribute("listOfMonths",listOfMonths);
		model.addAttribute("groupingEventByDay",groupingEventByDayAferSorting);
		String calender_link="active";
		model.addAttribute("calender_link",calender_link);
		
		return "admin/calender_event_table";
	}
	

	@GetMapping("/calender/form")
	public String showCalenderEventForm(Model model,HttpServletRequest response) {
		 CalendarEvent calendarEvent;
	       int month=1;
		try{
			String id=response.getParameter("id");
			calendarEvent=calendarEventService.getCalendarEventById(Integer.parseInt(id));
			month=calendarEvent.getMonth().getId();
			System.out.println("no Exception");
		}catch(Exception e) {
			calendarEvent=new CalendarEvent();
			System.out.println("Exception");
		}
		
      
		List<Month> listOfMonths=monthService.showAllMonth();
		String calender_link="active";
		model.addAttribute("firstMonthDays",getDaysFromMonth(month));
		model.addAttribute("listOfMonths",listOfMonths);
		model.addAttribute("calender_link",calender_link);
		model.addAttribute("calendarEvent",calendarEvent);
		return "admin/calender_event_form";	
	}
	
	
	
	
	
	@PostMapping("/calendar/event/save")
	public String saveCalendarEvent(CalendarEvent calendarEvent,RedirectAttributes redirectAttr) {
		Converter converter =new Converter();
		calendarEvent.setYear(converter.getCurrentNepliYear());
	
		calendarEventService.saveCalendarEvent(calendarEvent);
		if(calendarEvent.getId()==null) {
			redirectAttr.addFlashAttribute("success","Event has been added successfully");
		}else {
			redirectAttr.addFlashAttribute("success","Event has been updated successfully");
		}
	  
		return "redirect:/admin/calender-event?month="+calendarEvent.getMonth().getId();
		
	}
	
	
	@GetMapping("/calendar/event/deleteById")
	public String deleteCalendarEventById(@RequestParam("month")String month,@RequestParam("id")String id,Model model,RedirectAttributes redirectAttr ) {
		if(isNumeric(month)==true && isNumeric(id)==true) {
		   try { calendarEventService.deleteCalendarEventByid(Integer.parseInt(id));
		   redirectAttr.addFlashAttribute("success","Event has been deleted successfully");
		   }
		   catch(Exception e) {
			  return "admin/";
		   }
		   return "redirect:/admin/calender-event?month="+Integer.parseInt(month);
		}else {
			  return "redirect:/admin/calender-event?month="+Integer.parseInt(month);
		}
  }
	
	

	
	
	
	// delete part
	
	@GetMapping("/calendar/event/deleteByDay")
	public String deleteCalendarEventByDay(@RequestParam("month")String month,@RequestParam("day")String day,Model model,RedirectAttributes redirectAttr ) {
		try {
			 Converter converter=new Converter();
			calendarTitleService.deleteCalendarTitle(converter.getCurrentNepliYear(), Integer.parseInt(month), Integer.parseInt(day));
		}catch(Exception e) {
			
		}
		
		if(isNumeric(month)==true && isNumeric(day)==true) {
		   try { calendarEventService.deleteCalendarEventByDay(Integer.parseInt(day));
		   redirectAttr.addFlashAttribute("success","Event has been deleted successfully");
		   }
		   catch(Exception e) {
			  return "admin/";
		   }
		   return "redirect:/admin/calender-event?month="+Integer.parseInt(month);
		}else {
			return "redirect:/admin/calender-event?month="+Integer.parseInt(month);
		}
  }
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Integer d = Integer.parseInt(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	// api's
	@GetMapping("/event/getmonth/{id}")
    	public  @ResponseBody  int getDaysFromMonth(@PathVariable(name="id")int id) {		
		Converter converter =new Converter();
		String dateInString=date.toString();
		  String dateInArray[]=dateInString.split("-");
		  NepaliDate nepaliDate=converter.getNepaliDate(Integer.parseInt(dateInArray[0]),Integer.parseInt(dateInArray[1]),Integer.parseInt(dateInArray[2]));
		return converter.getNepaliMonthFromYear(nepaliDate.getSaal(), id);
	
	  }
  @GetMapping("/event/month/{id}")
    public @ResponseBody Map<Integer,List<CalendarEvent>> getMonthEvent(@PathVariable(name="id") int id){
	  Map<Integer, List<CalendarEvent>> groupingEventByDay = new HashMap<>();
		List<CalendarEvent> allMonthEvent=new ArrayList<>();  
	
		allMonthEvent=calendarEventService.getAllMonthEvent(3,2078);
		groupingEventByDay =  allMonthEvent.stream().collect(Collectors.groupingBy(CalendarEvent::getDay));
		return groupingEventByDay;
	  
  }
	
	
	

	
	public void seedMonth() {
		if(monthService.countMonth()<=0) {
			monthService.saveMonth(new Month("Baishak"));	
			monthService.saveMonth(new Month("Jesth"));	
			monthService.saveMonth(new Month("Aasar"));	
			monthService.saveMonth(new Month("Shrawn"));	
			monthService.saveMonth(new Month("Bhadra"));	
			monthService.saveMonth(new Month("Asoj"));	
			monthService.saveMonth(new Month("Kartik"));	
			monthService.saveMonth(new Month("Mangsir"));	
			monthService.saveMonth(new Month("Poush"));	
			monthService.saveMonth(new Month("Magh"));	
			monthService.saveMonth(new Month("Falgun"));	
			monthService.saveMonth(new Month("Chaitra"));	
		}
		
  
   
  	
	}
	

}
