package com.college.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Parent")
@Table(name="parents")
public class Parent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="father_first_name",length=10,nullable=true)
	private String fatherFirstName;
	
	@Column(name="father_middle_name",length=10,nullable=true)
	private String fatherMiddleName;

	@Column(name="father_last_name",length=10,nullable=true)
	private String fatherLastName;
    
	@Column(name="mother_first_name",length=10,nullable=true)
	private String motherFirstName;
	
	@Column(name="mother_middle_name",length=10,nullable=true)
	private String motherMiddleName;

	@Column(name="mother_last_name",length=10,nullable=true)
	private String motherLastName;
	
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

	@Column(name="contact",nullable=true,length=15)
	private String  contact;
	
	@Column(name="address",nullable=true,length=100)
	private String  address;
	
	 @OneToOne(targetEntity = Student.class, mappedBy = "parent")	    
	 private Student student;
	 @Column(name="created_at",nullable=true)
	 private Date createdAt;
	 @Column(name="updated_at",nullable=true)
	 private Date updatedAt;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", fatherFirstName=" + fatherFirstName + ", fatherMiddleName=" + fatherMiddleName
				+ ", fatherLastName=" + fatherLastName + ", motherFirstName=" + motherFirstName + ", motherMiddleName="
				+ motherMiddleName + ", motherLastName=" + motherLastName + ", contact=" + contact + ", address="
				+ address +  "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFatherFirstName() {
		return fatherFirstName;
	}

	public void setFatherFirstName(String fatherFirstName) {
		this.fatherFirstName = fatherFirstName;
	}

	public String getFatherMiddleName() {
		return fatherMiddleName;
	}

	public void setFatherMiddleName(String fatherMiddleName) {
		this.fatherMiddleName = fatherMiddleName;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public void setFatherLastName(String fatherLastName) {
		this.fatherLastName = fatherLastName;
	}

	public String getMotherFirstName() {
		return motherFirstName;
	}

	public void setMotherFirstName(String motherFirstName) {
		this.motherFirstName = motherFirstName;
	}

	public String getMotherMiddleName() {
		return motherMiddleName;
	}

	public void setMotherMiddleName(String motherMiddleName) {
		this.motherMiddleName = motherMiddleName;
	}

	public String getMotherLastName() {
		return motherLastName;
	}

	public void setMotherLastName(String motherLastName) {
		this.motherLastName = motherLastName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	

}
