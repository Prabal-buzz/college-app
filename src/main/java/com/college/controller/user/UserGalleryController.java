package com.college.controller.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.college.model.Gallery;
import com.college.model.GalleryCategory;
import com.college.service.GalleryCategoryInterface;
import com.college.service.GalleryInterfaceImpl;

@Controller
public class UserGalleryController {
	@Autowired
	private GalleryInterfaceImpl galleryService;

	@Autowired
	private GalleryCategoryInterface galleryCategoryService;

	@GetMapping("/gallery")
	public String showGallery(Model model) {
		List<GalleryCategory> galleryCategories = galleryCategoryService.getAll();
		Map<String, GalleryCategory> listOfCategory = galleryCategoryService.getCategoryList();

		String active = "gallery";
		model.addAttribute("active", active);
		model.addAttribute("galleryCategories", listOfCategory);
		return "/front/gallery";
	}
	@GetMapping("/gallery/details/{id}")
	public String getDetails(@PathVariable("id")int id,Model model) {
		
		List<Gallery> galleryList=galleryService.getFirstGalleryFromCategory(id);
		model.addAttribute("galleryList",galleryList);
		
		
		return "/front/gallery_details";
	}

}
