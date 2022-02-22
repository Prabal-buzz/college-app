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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Fee")
@Table(name="fees")
public class Fee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="is_full_schoolarship")
	private boolean schoolarship;
	


	@Column(name="semester_first" ,length=500)
	private Integer semesterFirst=0;
	
	@Column(name="semester_second" ,length=500)
	private Integer semesterSecond=0;
	
	@Column(name="semester_third" ,length=500)
	private Integer semesterThird=0;
	
	@Column(name="semester_fourth" ,length=500)
	private Integer semesterFourth=0;
	
	@Column(name="semester_fifth" ,length=500)
	private Integer semesterFifth=0;
	
	@Column(name="semester_sixth" ,length=500)
	private Integer semesterSixth=0;
	
	@Column(name="semeter_seventh" ,length=500)
	private Integer semesterSeventh=0;
	
	@Column(name="semester_eight" ,length=500)
	private Integer semesterEight=0;
	@Column(length=255)
	private String document;
	

	
	@Column(name="created_at",nullable=true)
	private Date createdAt;
	
	@Column(name="updated_at",nullable=true)
	private Date updatedAt;
	
	 @OneToOne(targetEntity = Student.class, mappedBy = "fee")	    
	 private Student student;
	 
	 @OneToMany(targetEntity=Payment.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="fee_id", referencedColumnName="id")
	 private List<Payment> payment;

	@Override
	public String toString() {
		return "Fee [id=" + id + ", isFullSchoolarship=" + schoolarship + ", semesterFirst=" + semesterFirst
				+ ", semesterSecond=" + semesterSecond + ", semesterThird=" + semesterThird + ", semesterFourth="
				+ semesterFourth + ", semesterFifth=" + semesterFifth + ", semesterSixth=" + semesterSixth
				+ ", semesterSeventh=" + semesterSeventh + ", semesterEight=" + semesterEight + ", document=" + document
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", student=" + student + "]";
	}



	public boolean isSchoolarship() {
		return schoolarship;
	}

	public void setSchoolarship(boolean schoolarship) {
		this.schoolarship = schoolarship;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Integer getSemesterFirst() {
		return semesterFirst;
	}

	public void setSemesterFirst(Integer semesterFirst) {
		this.semesterFirst = semesterFirst;
	}

	public Integer getSemesterSecond() {
		return semesterSecond;
	}

	public void setSemesterSecond(Integer semesterSecond) {
		this.semesterSecond = semesterSecond;
	}

	public Integer getSemesterThird() {
		return semesterThird;
	}

	public void setSemesterThird(Integer semesterThird) {
		this.semesterThird = semesterThird;
	}

	public Integer getSemesterFourth() {
		return semesterFourth;
	}

	public void setSemesterFourth(Integer semesterFourth) {
		this.semesterFourth = semesterFourth;
	}

	public Integer getSemesterFifth() {
		return semesterFifth;
	}

	public void setSemesterFifth(Integer semesterFifth) {
		this.semesterFifth = semesterFifth;
	}

	public Integer getSemesterSixth() {
		return semesterSixth;
	}

	public void setSemesterSixth(Integer semesterSixth) {
		this.semesterSixth = semesterSixth;
	}

	public Integer getSemesterSeventh() {
		return semesterSeventh;
	}

	public void setSemesterSeventh(Integer semesterSeventh) {
		this.semesterSeventh = semesterSeventh;
	}

	public Integer getSemesterEight() {
		return semesterEight;
	}

	public void setSemesterEight(Integer semesterEight) {
		this.semesterEight = semesterEight;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
