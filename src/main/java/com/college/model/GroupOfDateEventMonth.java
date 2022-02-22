package com.college.model;
import com.college.nepalidateconverter.Converter;

public class GroupOfDateEventMonth {
   
   @Override
	public String toString() {
		return "GroupOfDateEventMonth [nepaliDay=" + nepaliDay + ", calendarTitle=" + calendarTitle + ", englishDay="
				+ englishDay + ", bar=" + bar + "]";
	}
private int  nepaliDay;
   private CalendarTitle calendarTitle;
   private int englishDay;
   private int  bar;
   
   public int getNepaliDay() {
	   return nepaliDay;
   }
   
   public int getEnglishDay() {
	   return englishDay;
   }
   public int getBar() {
	   return bar;
   }
  
  public CalendarTitle getCalendarTitle() {
	  return calendarTitle;
  }
  
  public void setNepaliDay(int nepaliDay) {
	  this.nepaliDay=nepaliDay;
	  
  }
  public void setCalendarTitle(CalendarTitle calendarTitle) {
	this.calendarTitle = calendarTitle;
}

public void setEnglishDay(int englishDay) {
	  this.englishDay=englishDay;
	  
  }
  public void setBar(int bar) {
	  this.bar=bar;
	  
  }
  
  
 public boolean isDateToday(int eYear,int eMonth,int nDay) {
	 Converter converter=new Converter();
	 return converter.isDateToday( eYear, eMonth,nDay);
	 
 }

	
}
