package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Gallery;
import com.college.model.GalleryCategory;
import com.college.repository.GalleryRepository;

@Service
public class GalleryInterfaceImpl implements GalleryInterface {
	@Autowired 
	private GalleryRepository galleryRepsository;

	@Override
	public void saveGallery(Gallery gallery) {
		galleryRepsository.save(gallery);
	}

	@Override
	public void deleteGallery(int id) {
		galleryRepsository.deleteById(id);
		
	}

	@Override
	public List<Gallery> showAllGallery() {
		
		return galleryRepsository.findAll();
	}

	@Override
	public Gallery findById(int id) {
		// TODO Auto-generated method stub
		return galleryRepsository.getById(id);
	}

	@Override
	public List<Gallery> getFirstGalleryFromCategory(int category_id) {
	
		return galleryRepsository.getFirstGalleryFromCategory(category_id);
	}


	

}
