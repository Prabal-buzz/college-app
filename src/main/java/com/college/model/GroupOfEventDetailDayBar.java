package com.college.model;

import java.util.ArrayList;
import java.util.List;

public class GroupOfEventDetailDayBar {

	public int getNepaliDay() {
		return nepaliDay;
	}
	public String getBaar() {
		return baar;
	}
	public List<String> getCalendarEvent() {
		return calendarEvent;
	}
	public String getEnglishDate() {
		return englishDate;
	}
	public void setNepaliDay(int nepaliDay) {
		this.nepaliDay = nepaliDay;
	}
	public void setBaar(String baar) {
		this.baar = baar;
	}
	public void setCalendarEvent(String calendarEvent) {
		this.calendarEvent.add(calendarEvent);
	}
	@Override
	public String toString() {
		return "GroupOfEventDetailDayBar [nepaliDay=" + nepaliDay + ", baar=" + baar + ", calendarEvent="
				+ calendarEvent + ", englishDate=" + englishDate + "]";
	}
	public void setEnglishDate(String englishDate) {
		this.englishDate = englishDate;
	}
	private int nepaliDay;
   private String baar;
   private List<String> calendarEvent=new ArrayList<>();
   private String englishDate;
   
}
