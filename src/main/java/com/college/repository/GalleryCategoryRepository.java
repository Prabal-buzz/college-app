package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.GalleryCategory;

public interface GalleryCategoryRepository extends JpaRepository<GalleryCategory, Integer> {

}
