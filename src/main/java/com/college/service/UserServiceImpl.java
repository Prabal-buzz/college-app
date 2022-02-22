package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Student;
import com.college.model.User;
import com.college.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public void saveUser(User user) {
		this.userRepo.save(user);		
	}
	@Override
	public User fetchStudentFromEmail(String email) {
		 return this.userRepo.getUsertByEmail(email);
		
	}
	@Override
	public List<User> showAllUser() {
	return	this.userRepo.findAll();
	}
	@Override
	public Integer countUser() {
		
		return (int) userRepo.count();
	}
	@Override
	public User findUserById(Integer id) {
	 return userRepo.getById(id);
	}

}
