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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;



@Entity(name="Student")
@Table(name="students")
public class Student {
 

@Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(length=100)
 private Integer id;
 @Column(name="first_name",length=20,nullable=false)
 private String firstName;
 @Column(name="middle_name",length=20,nullable=false)
 private String middleName;
 @Column(name="last_name",length=20,nullable=false)
 private String lastName;
 @Column(name="contact",length=12,nullable=false)
 private String contact;

 @Column(length=100,nullable=true,unique=false)
 private String image;
 
 @Column(length=100)
 private String email;
 @Column(length=255)
 private String password;

 
// @DateTimeFormat(pattern = "mm/dd/yyyy")
 private Date dob;
 
 @Column(length=8,nullable=false,unique=false)
 private String gender;
 
 @ManyToOne(targetEntity=Program.class)
 private Program program;
 
 @ManyToOne(targetEntity=Year.class)
 private Year registrationyear;
 
 @OneToMany(targetEntity=Result.class,cascade=CascadeType.ALL)
 @JoinColumn(name="student_id", referencedColumnName="id")
 private List<Result> result;
 
 public Year getRegistrationyear() {
	return registrationyear;
}

public void setRegistrationyear(Year registrationyear) {
	this.registrationyear = registrationyear;
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

public Fee getFee() {
	return fee;
}

public void setFee(Fee fee) {
	this.fee = fee;
}

@OneToOne(targetEntity = Parent.class, cascade = CascadeType.ALL)
 private Parent parent;

@OneToOne(targetEntity = Fee.class, cascade = CascadeType.ALL)
private Fee fee;
 
 @Column(name="created_at",nullable=true)
 private Date createdAt;
 @Column(name="updated_at",nullable=true)
 private Date updatedAt;
 
 public Parent getParent() {
	return parent;
}

public void setParent(Parent parent) {
	this.parent = parent;
}


 
 

@Override
public String toString() {
	return "Student [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
			+ ", contact=" + contact + ", image=" + image + ", email=" + email + ", password=" + password + ", dob="
			+ dob + ", gender=" + gender + ", program=" + program + ", registrationyear=" + registrationyear
			+ ", parent=" + parent + ", fee=" + fee + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
}



public Program getProgram() {
	return program;
}

public void setProgram(Program program) {
	this.program = program;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}






public String getEmail() {
	return email;
}

public String getPassword() {
	return password;
}

public void setEmail(String email) {
	this.email = email;
}

public void setPassword(String password) {
	this.password = password;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}




public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getMiddleName() {
	return middleName;
}

public void setMiddleName(String middleName) {
	this.middleName = middleName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}



public Date getDob() {
	return dob;
}

public void setDob(Date dob) {
	this.dob = dob;
}


 
 
}