package com.college.service;

import java.util.List;


import com.college.model.CalendarTitle;

public interface CalendarTitleService {
    public void saveCalendarTitle(CalendarTitle calendarTitle);
    public CalendarTitle getCalendarTitleById(Integer id);
    public void deleteCalendarTitleById(Integer id);
    public List<CalendarTitle> getAllCalendarTitle();
    public CalendarTitle  findCalendarTitleByYearMonthDay(int year,int month,int day);
    public String  findCalendarTitleNameByYearMonthDay(int year,int month,int day);
    public List<CalendarTitle> getAllMonthEventTitle(int month);
    public void deleteCalendarTitle(int year,int month, int day);

}
