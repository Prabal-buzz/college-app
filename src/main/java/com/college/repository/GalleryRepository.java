package com.college.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.college.model.Gallery;
import com.college.model.Student;

public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
	
	
	
	@Query("SELECT s FROM Gallery s where s.galleryCategory.id=?1")
	public List<Gallery> getFirstGalleryFromCategory(int id);

	
}
