package com.college.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CalendarList {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	private Integer yearId;
	
	public Integer getYearId() {
		return yearId;
	}


	public void setYearId(Integer yearId) {
		this.yearId = yearId;
	}


	public Integer getId() {
		return id;
	}


	


	public void setId(Integer id) {
		this.id = id;
	}


	


	public String calculate() {
		return null;
	}

}
