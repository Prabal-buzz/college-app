package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.NewsAndAnnouncement;
import com.college.repository.NewsAndAnnouncementRepository;

@Service
public class NewsAndAnnouncementServiceImpl implements NewsAndAnnouncementService {
	
	@Autowired 
    private NewsAndAnnouncementRepository newsAndAnnouncementRepository;

	@Override
	public void saveNewsAndAnnouncement(NewsAndAnnouncement newsAndAnnouncement) {
	  
		newsAndAnnouncementRepository.save(newsAndAnnouncement);
		
	}

	@Override
	public NewsAndAnnouncement getNewsAndAnnouncementById(Integer id) {
		
		return newsAndAnnouncementRepository.getById(id);
	}

	@Override
	public List<NewsAndAnnouncement> getAllNewsAndAnnouncement() {
		return newsAndAnnouncementRepository.findAll();
	}

	@Override
	public void deleteNewsAndAnnouncementById(Integer id) {
		 newsAndAnnouncementRepository.deleteById(id);
		
	}

}
