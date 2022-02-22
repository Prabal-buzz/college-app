package com.college.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.college.model.Gallery;
import com.college.model.GalleryCategory;
import com.college.service.GalleryCategoryInterface;
import com.college.service.GalleryInterfaceImpl;

@RequestMapping("/admin/gallery")
@Controller
public class GalleryController {
	private long millis = System.currentTimeMillis();
	private Date date = new Date(millis);
	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/resources/static/admin/gallery";	
	
	@Autowired
	 private GalleryCategoryInterface galleryCategoryService;
	
	@Autowired
	private GalleryInterfaceImpl galleryService;
	
	@GetMapping(" ")
	public String showGallery(Model model ) {
		List<Gallery> galleryList=galleryService.showAllGallery();
		String gallery_link="active";
		model.addAttribute("gallery_link",gallery_link);
		model.addAttribute("galleryList",galleryList);
		return "admin/gallery_table";
	}
	@GetMapping("/form")
	public String getForm(Model model) {
		List<GalleryCategory> galleryCategory=galleryCategoryService.getAll();

		model.addAttribute("gallery",new Gallery());
		model.addAttribute("galleryCategories",galleryCategory);
		String gallery_link="active";
		model.addAttribute("gallery_link",gallery_link);
		return "admin/gallery_form";
	}
	
	@GetMapping("/category")
	public  String getCategory(Model model){
		List<GalleryCategory> galleryCategory=galleryCategoryService.getAll();
		String gallery_link="active";
		model.addAttribute("gallery_link",gallery_link);
		model.addAttribute("galleryCategories",galleryCategory);
		return "admin/gallery_category_table";
	}
	
	@GetMapping("/category/form")
	public String getCategoryForm(Model model) {
		String gallery_link="active";
		model.addAttribute("gallery_link",gallery_link);
		GalleryCategory galleryCategory=new GalleryCategory();
		model.addAttribute("galleryCategory",galleryCategory);
		return "admin/gallery_category_form";
	}
	
	@PostMapping("/category/save")
	public String getCategorySave(GalleryCategory galleryCategory) {
		galleryCategory.setCreatedAt(date);
		try {
			galleryCategoryService.saveCategory(galleryCategory);	
		}catch(Exception e){
			System.out.println(e);
		}
		
		System.out.println(galleryCategory);
		return "redirect:/admin/gallery/category" ;
		
	}
	
	// gallery part

	@PostMapping("/save")
	public String saveGallery(@RequestParam("category_id") int id ,@RequestParam("image") MultipartFile file) {
		new File(uploadDirectory).mkdir();
	
		Gallery gallery=new Gallery();
		gallery.setCreatedAt(date);
		gallery.setGalleryCategory(galleryCategoryService.findCategoryById(id));
		
		System.out.println(file);
		  if(file.isEmpty()) {
				
			}else{
					String fileName = System.currentTimeMillis()
						+ file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
				Path fileAndPath = Paths.get(uploadDirectory, fileName);
				gallery.setImage(fileName);
				try {
					Files.write(fileAndPath, file.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		  galleryService.saveGallery(gallery);
		return "redirect:/admin/gallery/";
	}
}
