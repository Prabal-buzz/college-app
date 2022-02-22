package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.CalendarEvent;
import com.college.model.CalendarTitle;
import com.college.repository.CalendarTitleRepository;

@Service
public class CalendarTitleServiceImpl implements CalendarTitleService {
	
	@Autowired 
	private CalendarTitleRepository calendarTitleRepository;

	@Override
	public void saveCalendarTitle(CalendarTitle calendarTitle) {
		calendarTitleRepository.save(calendarTitle);		
	}

	@Override
	public CalendarTitle getCalendarTitleById(Integer id) {
		return calendarTitleRepository.getById(id);
		
	}

	@Override
	public void deleteCalendarTitleById(Integer id) {
		calendarTitleRepository.deleteById(id);
		
	}

	@Override
	public List<CalendarTitle> getAllCalendarTitle() {
		return calendarTitleRepository.findAll();
	}

	@Override
	public CalendarTitle findCalendarTitleByYearMonthDay(int year, int month, int day) {
		 return calendarTitleRepository.findCalendarTitleByYearMonthDay(year, month, day);
	}

	@Override
	public List<CalendarTitle> getAllMonthEventTitle(int month) {
		
		return calendarTitleRepository.getAllMonthEventTitle(month);
	}

	@Override
	public String findCalendarTitleNameByYearMonthDay(int year, int month, int day) {
		 String title="";
	     try {
	    	 title=calendarTitleRepository.findCalendarTitleByYearMonthDay(year, month, day).getTitle();
	     }catch(Exception e){
	    	 title="";
	     }
	     
		 return title;		
	}

	@Override
	public void deleteCalendarTitle(int year, int month, int day) {
		try { CalendarTitle calendarTitle= calendarTitleRepository.findCalendarTitleByYearMonthDay(year, month, day);
		      calendarTitleRepository.deleteById(calendarTitle.getId());
		 }catch(Exception e) {
			
		}
	}

}
