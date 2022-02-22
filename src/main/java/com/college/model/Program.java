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
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity(name="Program")
@Table(name="programs")
public class Program {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column(length=30,nullable=false,unique=true)
	private String name;
	
	
	 @OneToMany(targetEntity=Student.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="program_id", referencedColumnName="id")
	 private List<Student> student;
	 
	 @OneToMany(targetEntity=ResultCategory.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="program_id", referencedColumnName="id")
	 private List<ResultCategory> resultCategory;
	
	@Column(name="created_at",nullable=true)
	private java.sql.Date createdAt;
	
	 @Column(name="updated_at",nullable=true)
	 private java.sql.Date updatedAt;
	 
	 @OneToOne(targetEntity = AdmissionFee.class, mappedBy = "program",cascade=CascadeType.ALL)	    
	 private AdmissionFee admissionFee;
	 
	 @OneToOne(targetEntity = SecurityFee.class, mappedBy = "program",cascade=CascadeType.ALL)	    
	 private SecurityFee securityFee;
	 
	 @Column(name="has_fee")
	 private boolean hasFee=false;
	 
	 @Column(name="has_security")
	 private boolean hasSecurity=false;
	
	public SecurityFee getSecurityFee() {
		return securityFee;
	}
	public boolean isHasSecurity() {
		return hasSecurity;
	}
	public void setSecurityFee(SecurityFee securityFee) {
		this.securityFee = securityFee;
	}
	public void setHasSecurity(boolean hasSecurity) {
		this.hasSecurity = hasSecurity;
	}
	public AdmissionFee getAdmissionFee() {
		return admissionFee;
	}
	public void setAdmissionFee(AdmissionFee admissionFee) {
		this.admissionFee = admissionFee;
	}
	public boolean isHasFee() {
		return hasFee;
	}
	public void setHasFee(boolean hasFee) {
		this.hasFee = hasFee;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
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
	@Override
	public String toString() {
		return "Program [id=" + id + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
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
}
