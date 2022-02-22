package com.college.service;

import java.util.List;

import com.college.model.Gallery;

public interface GalleryInterface {
	
	public void saveGallery(Gallery gallery);
	public void deleteGallery(int id);
	public List<Gallery> showAllGallery();
	public Gallery findById(int id);
	public List<Gallery> getFirstGalleryFromCategory(int category_id);

}
