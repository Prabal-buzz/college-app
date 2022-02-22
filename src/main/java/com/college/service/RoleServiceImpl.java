package com.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.model.Role;
import com.college.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role saveRole(Role role) {
	  return	roleRepository.save(role);

	}

	@Override
	public Integer countRole() {
	
		return (int) roleRepository.count();
	}

	@Override
	public List<Role> showAllRole() {
		return roleRepository.findAll();

	}

	@Override
	public Role findRoleById(Integer id) {
		
		return roleRepository.getById(id) ;
	}

}
