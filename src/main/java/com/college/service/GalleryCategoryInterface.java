package com.college.service;

import java.util.List;
import java.util.Map;

import com.college.model.Gallery;
import com.college.model.GalleryCategory;

public interface GalleryCategoryInterface {
	
	public List<GalleryCategory> getAll();
	public void saveCategory(GalleryCategory galleryCateogry);
	public GalleryCategory findCategoryById(int id);
	public Map<String,GalleryCategory> getCategoryList();
	public List<Gallery> getGallery(int id);
	
	

}
