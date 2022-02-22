package com.college.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="galleries")
public class Gallery {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=255)
	private String image;
	
	@Column(name="created_at",nullable=true)
	private Date createdAt;
	
	@Column(name="updated_at",nullable=true)
	private Date updatedAt;
	
	@ManyToOne(targetEntity=GalleryCategory.class)
	 private GalleryCategory galleryCategory;

	public Integer getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public GalleryCategory getGalleryCategory() {
		return galleryCategory;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setGalleryCategory(GalleryCategory galleryCategory) {
		this.galleryCategory = galleryCategory;
	}

	@Override
	public String toString() {
		return "Gallery [id=" + id + ", image=" + image + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", galleryCategory=" + galleryCategory + "]";
	}
	
	
}
