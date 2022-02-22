package com.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.model.NewsAndAnnouncement;

public interface NewsAndAnnouncementRepository extends JpaRepository<NewsAndAnnouncement, Integer> {

}
