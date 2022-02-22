package com.college.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="AdmissionFee")
@Table(name="admission_fees")
public class AdmissionFee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=200)
	private Integer amount;
	@Column(name="created_at",nullable=true)
	private Date createdAt;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "AdmissionFee [id=" + id + ", amount=" + amount + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", program=" + program + "]";
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
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

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	@Column(name="updated_at",nullable=true)
	private Date updatedAt;
	
	@OneToOne(targetEntity = Program.class)
	private Program program;
	
	

}
