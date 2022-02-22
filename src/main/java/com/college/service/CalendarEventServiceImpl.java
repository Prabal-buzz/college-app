package com.college.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.CalendarEvent;
import com.college.model.GroupOfDateEventMonth;
import com.college.model.GroupOfEventDetailDayBar;
import com.college.model.ListMonthEvent;
import com.college.nepalidateconverter.Converter;
import com.college.nepalidateconverter.EnglishDate;
import com.college.nepalidateconverter.NepaliDate;
import com.college.repository.CalendarEventRepository;

@Service
public class CalendarEventServiceImpl implements CalendarEventService {
	Converter converter=new Converter();
    @Autowired
    private CalendarEventRepository calendarEventRepository;
	
    @Autowired
	private CalendarTitleService calendarTitleService;
	
	@Override
	public void saveCalendarEvent(CalendarEvent calendarEvent) {
		calendarEventRepository.save(calendarEvent);
	}

	@Override
	public List<CalendarEvent> getAllMonthEvent(int month,int saal) {
	
		return calendarEventRepository.getAllMonthEvent(month,saal);
	}

	@Override
	public void deleteCalendarEventByDay(int day) {
		calendarEventRepository.deleteCalendarEventByDay(day);
		
	}

	@Override
	public void deleteCalendarEventByid(int id) {
		calendarEventRepository.deleteById(id);
		
	}

	@Override
	public CalendarEvent getCalendarEventById(Integer id) {
		
		return 	calendarEventRepository.findById(id).get();
	}
	

	@Override
	public StringBuffer getTwoEnglishMonthNameFromNepaliDate(int nYear, int nMonth) {
		  int noOfDay=converter.getNepaliMonthFromYear(nYear, nMonth);
		EnglishDate engDate;
		Set<String> set=new HashSet<>();
		try {
		for(int i=1;i<=noOfDay;i++) {
			engDate=converter.getEnglishDate(nYear, nMonth, i);
			set.add(engDate.getMonthAsText());
		}
	}catch(Exception e) {
		
	}
		
    StringBuffer str=new StringBuffer();
    
    for(String s:set) {
    	str.append(s+"/");
    }
    str.append(converter.getEnglishDate(nYear, nMonth, 1).getYear());
	
		return str ;
	}

	@Override
	public String getMonthInNepli(int month) {
		NepaliDate nepDate=new NepaliDate();
		return nepDate.monthInNepali[month-1];
	    
	}

	@Override
	public List<GroupOfDateEventMonth> getAllCalendarDataWithTitle(int currentSal, int month,int noOfDay) {
	
		List<GroupOfDateEventMonth> listGroupOfDateEventMonth=new ArrayList<>(32); 
		 for(int i=1;i<=noOfDay;i++) {
	    	   GroupOfDateEventMonth group=new GroupOfDateEventMonth();
	    	   group.setNepaliDay(i);
	    	   group.setBar(converter.getBar(currentSal, month, i));
	    	   group.setCalendarTitle(calendarTitleService.findCalendarTitleByYearMonthDay(currentSal, month, i));
	    	   group.setEnglishDay(converter.getEnglishDate(currentSal, month, i).getDate());
	    	   listGroupOfDateEventMonth.add(group);
	       }
		 
		 return listGroupOfDateEventMonth;
	}

	@Override
	public List<GroupOfEventDetailDayBar> getAllCalendarDataWithDetail(int currentSal, int month, int noOfDay) {
		
		Map<Integer, List<CalendarEvent>> groupingEventByDay;
		Map<Integer, List<CalendarEvent>> groupingEventByDayAferSorting;
		List<CalendarEvent> allMonthEvent=new ArrayList<>();
		allMonthEvent=getAllMonthEvent(month,currentSal);
		List<GroupOfEventDetailDayBar> listGroupOfEventDetailDayBar=new ArrayList<>(); 
		
		groupingEventByDay =  allMonthEvent.stream().collect(Collectors.groupingBy(CalendarEvent::getDay));
		groupingEventByDayAferSorting=groupingEventByDay
				.entrySet()
				.stream()
			    .sorted(Map.Entry.comparingByKey()) 			
			    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
			    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		
		
		for(Map.Entry<Integer,List<CalendarEvent>> map: groupingEventByDayAferSorting.entrySet()){
			
			GroupOfEventDetailDayBar groupOfEventDetailDayBar=new GroupOfEventDetailDayBar();
			groupOfEventDetailDayBar.setNepaliDay(map.getKey());
			for(CalendarEvent calendarEvent:map.getValue()) {
				groupOfEventDetailDayBar.setCalendarEvent(calendarEvent.getEvent());
			}
			int baar=converter.getBar(currentSal, month, map.getKey());
			groupOfEventDetailDayBar.setBaar(EnglishDate.WEEK_DAYS[baar-1]);
			groupOfEventDetailDayBar.setEnglishDate(converter.getEnglishDate(currentSal, month, map.getKey()).toString());
			listGroupOfEventDetailDayBar.add(groupOfEventDetailDayBar);
		}
	
		 
		
		return listGroupOfEventDetailDayBar;
	}

	

}
