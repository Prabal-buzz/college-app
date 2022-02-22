package com.college.service;

import java.util.List;

import com.college.model.NewsAndAnnouncement;

public interface NewsAndAnnouncementService {
	
	public void saveNewsAndAnnouncement(NewsAndAnnouncement newsAndAnnouncement);
	public NewsAndAnnouncement getNewsAndAnnouncementById(Integer id);
	public List<NewsAndAnnouncement> getAllNewsAndAnnouncement();
	public void deleteNewsAndAnnouncementById(Integer id);

}
