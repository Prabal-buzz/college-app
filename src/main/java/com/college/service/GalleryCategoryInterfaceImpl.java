package com.college.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Gallery;
import com.college.model.GalleryCategory;
import com.college.repository.GalleryCategoryRepository;
import com.college.repository.GalleryRepository;

@Service
public class GalleryCategoryInterfaceImpl implements GalleryCategoryInterface {
    @Autowired
    private GalleryCategoryRepository galleryCategoryRepository;
    
    @Autowired
    private GalleryInterface galleryService;
    
    
    @Autowired 
    private GalleryRepository galleryRepository;
    
	 
	@Override
	public List<GalleryCategory> getAll() {
		return galleryCategoryRepository.findAll();
		
	}

	@Override
	public void saveCategory(GalleryCategory galleryCateogry) {
		galleryCategoryRepository.save(galleryCateogry);
	}

	@Override
	public GalleryCategory findCategoryById(int id) {
		return galleryCategoryRepository.getById(id);
	}
	
	

	@Override
	public Map<String, GalleryCategory> getCategoryList() {
		Map<String, GalleryCategory> listOfCategory=new HashMap();
		
		for(GalleryCategory g: this.getAll()) {
			System.out.println("Count...................................");
			System.out.println(1);
			listOfCategory.put(getFirstImageFromCategory(g.getId()), g);
		}
		
		return listOfCategory;
		 
		
	}

	@Override
	public List<Gallery> getGallery(int id) {
		
		return galleryRepository.getFirstGalleryFromCategory(id);
	}
	public String getFirstImageFromCategory(int id) {
		
		for(Gallery g: galleryRepository.getFirstGalleryFromCategory(id)) {
			return g.getImage();
		}
		return null;
	}

}
