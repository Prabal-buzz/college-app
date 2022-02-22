package com.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="calendar_title")
public class CalendarTitle {
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CalendarTitle [id=" + id + ", month=" + month + ", day=" + day + ", year=" + year + ", title=" + title
				+ "]";
	}

	public Month getMonth() {
		return month;
	}

	public Integer getDay() {
		return day;
	}

	public Integer getYear() {
		return year;
	}

	public String getTitle() {
		return title;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(targetEntity=Month.class)
    private Month month;

	private Integer day;
	

    private Integer year;
    
    @Column(length=255)
	private String title;

}
