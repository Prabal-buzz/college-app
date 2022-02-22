package com.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.college.model.Role;
import com.college.model.User;
import com.college.model.Year;
import com.college.repository.UserRepository;
import com.college.service.RoleService;
import com.college.service.UserService;
import com.college.service.YearService;

@RequestMapping("/admin/user")
@Controller
public class UserController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private YearService yearService;
	
	@Autowired
	private UserService userService;	
	
    
	@Autowired
	private UserRepository userRepo;
	

	@GetMapping("")
	public String showUserTable(Model model) {
		List<User> listOfUsers=userService.showAllUser();
		String user_link="active";
		model.addAttribute("listOfUsers",listOfUsers);
		model.addAttribute("user_link",user_link);
		return "admin/user_table";
	}
	
	@GetMapping("/register-form")
	public String userRegisterForm(Model model) {
		List<Role> listOfRoles=roleService.showAllRole();
		User user=new User();
		String user_link="active";
		model.addAttribute("user_link",user_link);
		model.addAttribute("user",user);
		model.addAttribute("listOfRoles",listOfRoles);
		return "admin/user_register_form";
	}
	
	@PostMapping("/save")
	public String saveUser(User user) {
		if(user.getId()!=null) {
			
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encoded = encoder.encode(user.getUnHashedPassword());
			user.setPassword(encoded);
		}else {
		    user.setEnabled(false);
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String encoded = encoder.encode(user.getUnHashedPassword());
			user.setPassword(encoded);
			
		}
		userService.saveUser(user);
	
		return "redirect:/admin/user";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id")Integer id ,Model model) {
		User user=userService.findUserById(id);
		List<Role> listOfRoles=roleService.showAllRole();
		model.addAttribute("user",user);
		String user_link="active";
		model.addAttribute("user_link",user_link);
		model.addAttribute("listOfRoles",listOfRoles);
		return "admin/user_register_form";
		
	}
	@GetMapping("/changePermission")
	public @ResponseBody void changePermission(@RequestParam("id") Integer id) {
		
		User user=userService.findUserById(id);
		
		
		if(user.isEnabled()==true)
		{
			user.setEnabled(false);
		}
		else {
			user.setEnabled(true);
		}
		
		this.userService.saveUser(user);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id")int id) {
		userRepo.deleteById(id);
		return "redirect:/admin/user";
	}
}
