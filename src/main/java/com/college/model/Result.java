package com.college.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Result")
@Table(name="results")
public class Result {
	public Integer getId() {
		return id;
	}
	
	public String getSymbolNo() {
		return symbolNo;
	}

	public void setSymbolNo(String symbolNo) {
		this.symbolNo = symbolNo;
	}

	public Integer getFullMark() {
		return fullMark;
	}
	public Integer getPassMark() {
		return passMark;
	}
	public Integer getObtainMark() {
		return obtainMark;
	}
	public java.sql.Date getCreatedAt() {
		return createdAt;
	}
	public java.sql.Date getUpdatedAt() {
		return updatedAt;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public void setFullMark(Integer fullMark) {
		this.fullMark = fullMark;
	}
	public void setPassMark(Integer passMark) {
		this.passMark = passMark;
	}
	public void setObtainMark(Integer obtainMark) {
		this.obtainMark = obtainMark;
	}
	public void setCreatedAt(java.sql.Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(java.sql.Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String symbolNo;
	private Integer fullMark;
	private Integer passMark;
	private Integer obtainMark;
	
	 @ManyToOne(targetEntity=Student.class)
	 private Student student;
	@Override
	public String toString() {
		return "Result [id=" + id + ", student=" + symbolNo + ", fullMark=" + fullMark + ", passMark=" + passMark
				+ ", obtainMark=" + obtainMark + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", resultCategory=" + resultCategory + "]";
	}
	@Column(name="created_at",nullable=true)
	private java.sql.Date createdAt;
	 @Column(name="updated_at",nullable=true)
	 private java.sql.Date updatedAt;
	 
	 public ResultCategory getResultCategory() {
		return resultCategory;
	}
	public void setResultCategory(ResultCategory resultCategory) {
		this.resultCategory = resultCategory;
	}
	@ManyToOne(targetEntity=ResultCategory.class)
	 private ResultCategory resultCategory;
	public Student getStudent() {
		return student;
	}

}
