package com.college.service;

import java.util.List;

import com.college.model.Role;

public interface RoleService {
    public Role saveRole(Role role);
    public Integer countRole();
    public List<Role> showAllRole();
    public Role findRoleById(Integer id);
}
