package com.college.nepalidateconverter;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.college.service.CalendarTitleService;

public class main {
	
	@Autowired
	private static CalendarTitleService calendarTitleService;
	
	public static void  print() {
		 System.out.println(calendarTitleService.findCalendarTitleNameByYearMonthDay(2078,1,1));
	}
	
   public static void main(String []args) {
	   long millis=System.currentTimeMillis();  
		Date date=new Date(millis);
	   Converter converter =new Converter();
//	   System.out.println(converter.getNepaliDate(2021, 8, 16));
//	   System.out.println(converter.getEnglishDate(2078, 4, 32));
//
//	   System.out.println(converter.getBar(2078, 4, 32));
//	   EnglishDate engDate=converter.getEnglishDate(2078,4,16);
//       NepaliDate nepaliDate= converter.getNepaliDate(engDate.getYear(), engDate.getMonth(), engDate.getDate());
//       System.out.println(converter.isDateToday( 2078, 4,16));
//       
//       String dateInString=date.toString();
//		String dateInArray[]=dateInString.split("-");
//		NepaliDate nepaliDates=converter.getNepaliDate(Integer.parseInt(dateInArray[0]),Integer.parseInt(dateInArray[1]),Integer.parseInt(dateInArray[2]));
//	   System.out.println(nepaliDates);
	  main m=new main();
	  m.print();
   }
}	
