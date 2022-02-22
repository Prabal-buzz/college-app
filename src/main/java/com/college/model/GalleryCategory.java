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
import javax.persistence.Table;

@Entity
@Table(name="gallery_categories")
public class GalleryCategory {
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	@Override
	public String toString() {
		return "GalleryCategory [id=" + id + ", name=" + name + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}

	public List<Gallery> getGallery() {
		return gallery;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setGallery(List<Gallery> gallery) {
		this.gallery = gallery;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
   
    private String name;
    
	@Column(name="created_at",nullable=true)
	private Date createdAt;
	
	@Column(name="updated_at",nullable=true)
	private Date updatedAt;
	
	  @OneToMany(targetEntity=Gallery.class,cascade=CascadeType.ALL)
		 @JoinColumn(name="gallery_category_id", referencedColumnName="id")
		 private List<Gallery> gallery;
	  
	  
}
