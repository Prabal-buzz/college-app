package com.college.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Payment")
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Integer id;
	
	@Column(length=15)
	 private String mode;
	
	@Column(length=255)
	private String voucher;
	
	 public String getVoucher() {
		return voucher;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	private Integer amount;
	 @Column(name="created_at",nullable=true)
	 private Date createdAt;
	 
	 
	 private Integer semester;
	
	 public Integer getId() {
		return id;
	}

	public String getMode() {
		return mode;
	}

	public Integer getAmount() {
		return amount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Integer getSemester() {
		return semester;
	}

	public User getUser() {
		return user;
	}

	public Fee getFee() {
		return fee;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	@ManyToOne(targetEntity=User.class)
	 private User user;
	 
	 @ManyToOne(targetEntity=Fee.class)
	 private Fee fee;

}
