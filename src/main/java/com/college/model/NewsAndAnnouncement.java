package com.college.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.college.nepalidateconverter.Converter;

@Entity(name="NewsAndAnnouncement")
@Table(name="news_and_announcement")
public class NewsAndAnnouncement {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="description" ,columnDefinition = "text")
	private String description;
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="created_at",nullable=true)
	private java.sql.Date createdAt;
	 @Column(name="updated_at",nullable=true)
	 private java.sql.Date updatedAt;
	@Override
	public String toString() {
		return "NewsAndAnnouncement [id=" + id + ", description=" + description + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	
	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public String convertIntoNepaliDate(int eYear,int eMonth,int day) {
		Converter converter=new Converter();
		return converter.getNepaliDate(eYear, eMonth, day).toString();
		
	}
}
