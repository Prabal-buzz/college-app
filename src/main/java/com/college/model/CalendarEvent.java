package com.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.stream.Collectors;
@Entity(name="CalendarEvent")
@Table(name="calendar_event")
public class CalendarEvent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
    @ManyToOne(targetEntity=Month.class)
     private Month month;
	
	private Integer day;
	

     private Integer year;
	

	
	@Column(columnDefinition = "TEXT")
	private String event;

	public Integer getId() {
		return id;
	}



	public Integer getDay() {
		return day;
	}

	

	public String getEvent() {
		return event;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public void setDay(Integer day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "CalendarEvent [id=" + id + ", month=" + month + ", day=" + day + ", year=" + year + ", event=" + event
				+ "]";
	}



	public Month getMonth() {
		return month;
	}







	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public void setMonth(Month month) {
		this.month = month;
	}



	




	public void setEvent(String event) {
		this.event = event;
	}
	
}
