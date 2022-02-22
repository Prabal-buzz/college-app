package com.college.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;



@Entity(name="User")
@Table(name="users")
public class User {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;

@Column(unique=true,nullable=false,length=50)
private String email;
@Column(nullable=false,length=120)
private String password;

@Column(nullable=false,length=60,name="unhased_password")
private String unHashedPassword;


@OneToMany(targetEntity=Payment.class,cascade=CascadeType.ALL)
@JoinColumn(name="user_id", referencedColumnName="id")
private List<Payment> payment;

@Column(name="created_at",nullable=true)
private Date createdAt;
@Column(name="updated_at",nullable=true)
private Date updatedAt;
@Column(name="is_enabled")
private boolean isEnabled=false;
@OneToMany(targetEntity=ResultCategory.class,cascade=CascadeType.ALL)
@JoinColumn(name="user_id", referencedColumnName="id")
private List<ResultCategory> resultCategory;

@ManyToOne(targetEntity=Role.class)
private Role role;

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
	return "User [id=" + id + ", email=" + email + ", password=" + password + ", unHashedPassword=" + unHashedPassword
			+ ", payment=" + payment + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", isEnabled="
			+ isEnabled + ", resultCategory=" + resultCategory + "]";
}

public Integer getId() {
	return id;
}



public void setId(Integer id) {
	this.id = id;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}

public String getEmail() {
	return email;
}

public User(Integer id, String email, String password) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	
}

public User( String email, String password) {
	super();
	this.email = email;
	this.password = password;
	
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public String getUnHashedPassword() {
	return unHashedPassword;
}

public List<Payment> getPayment() {
	return payment;
}

public boolean isEnabled() {
	return isEnabled;
}

public List<ResultCategory> getResultCategory() {
	return resultCategory;
}

public Role getRole() {
	return role;
}

public void setUnHashedPassword(String unHashedPassword) {
	this.unHashedPassword = unHashedPassword;
}

public void setPayment(List<Payment> payment) {
	this.payment = payment;
}

public void setEnabled(boolean isEnabled) {
	this.isEnabled = true;
}

public void setResultCategory(List<ResultCategory> resultCategory) {
	this.resultCategory = resultCategory;
}

public void setRole(Role role) {
	this.role = role;
}

public void setPassword(String password) {
	this.password = password;
}


}