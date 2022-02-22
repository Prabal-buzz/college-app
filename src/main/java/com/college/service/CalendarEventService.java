package com.college.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.college.model.CalendarEvent;
import com.college.model.GroupOfDateEventMonth;
import com.college.model.GroupOfEventDetailDayBar;
import com.college.model.ListMonthEvent;

public interface CalendarEventService {
   
	public void saveCalendarEvent(CalendarEvent calendarEvent);
	public List<CalendarEvent> getAllMonthEvent(int month,int saal);
	public CalendarEvent getCalendarEventById(Integer id);
	public void  deleteCalendarEventByDay(int day);
	public void  deleteCalendarEventByid(int id);
	public StringBuffer getTwoEnglishMonthNameFromNepaliDate(int nYear, int nMonth);
	public String getMonthInNepli(int month);
	public List<GroupOfDateEventMonth> getAllCalendarDataWithTitle(int currentSaal,int month,int noOfDay);
	public List<GroupOfEventDetailDayBar> getAllCalendarDataWithDetail(int currentSal,int month,int noOfDay);
	
	
}
