package com.college.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.college.model.Role;
import com.college.model.User;
import com.college.repository.UserRepository;
import com.college.service.RoleService;
import com.college.service.UserService;

@Controller
public class LoginController {
	  private	long millis=System.currentTimeMillis();  
	  private   Date date=new Date(millis); 
	    
	 @Autowired
	  private UserService userService;
	 @Autowired
	 private RoleService roleService;
	
	@GetMapping("/admin/login")
	public String loginPage() {
		this.seedUser();
		return "admin/login";
	}
	
	public void seedUser() {
		
		if(userService.countUser()<=0) {
			
		User user=new User();
		user.setEmail("admin@gmail.com");
		user.setUnHashedPassword("admin");
		user.setEnabled(true);
		user.setCreatedAt(date);
		user.setRole(seedRole());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode("admin");
		user.setPassword(encoded);
		userService.saveUser(user);
		}
	}


	public Role  seedRole() {
		if(roleService.countRole()<=0) {
			
			 Role role1 = roleService.saveRole(new Role("SUPERADMIN"));
			 Role role2=roleService.saveRole(new Role("ADMIN"));
			 Role role3=roleService.saveRole(new Role("TEACHER"));
			
			 return role1 ;
		}
		else {
			return roleService.findRoleById(1);
		}

	}
}
