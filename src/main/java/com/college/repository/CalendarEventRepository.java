package com.college.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.college.model.CalendarEvent;
import com.college.model.ListMonthEvent;

public interface CalendarEventRepository  extends JpaRepository<CalendarEvent,Integer>{

	@Query("SELECT c FROM CalendarEvent c WHERE c.month.id=?1 and c.year=?2 ORDER BY c.day DESC ")
	public List<CalendarEvent> getAllMonthEvent(int month,int saal); 
	
	@Modifying
	@Transactional
	@Query("DELETE from CalendarEvent c where c.day=?1")
	public void  deleteCalendarEventByDay(int day);
}
