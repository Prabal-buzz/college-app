package com.college.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Year")
@Table(name="years")
public class Year {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name",length=10)
	private String name;
	
	
	
	@OneToMany(targetEntity=CalendarEvent.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="year_id", referencedColumnName="id")
	private List<CalendarEvent> calendarEvent;
	
	@OneToMany(targetEntity=Student.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="year_id", referencedColumnName="id")
	
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Year [id=" + id + ", name=" + name  + ", isActive=" + isActive
				+ ", isCalender=" + isCalender + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Column(name="is_active")
	private boolean isActive=false;
	
	@Column(name="is_calender")
	private boolean isCalender=false;
	
	public boolean isCalender() {
		return isCalender;
	}
	public void setCalender(boolean isCalender) {
		this.isCalender = isCalender;
	}
	@Column(name="created_at",nullable=true)
	private Date createdAt;
	@Column(name="updated_at",nullable=true)
	private Date updatedAt;
	
	
	
}
