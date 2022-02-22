package com.college.service;

import java.util.List;

import com.college.model.Student;
import com.college.model.User;

public interface UserService {
 public void saveUser(User user);
 public User fetchStudentFromEmail(String email);
 public List<User> showAllUser();
 public Integer countUser();
 public User findUserById(Integer id);
}
