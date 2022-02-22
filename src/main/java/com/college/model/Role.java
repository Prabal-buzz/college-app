package com.college.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity(name="Role")
@Table(name="roles")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String name;
	public List<User> getUser() {
		return User;
	}
	public void setUser(List<User> user) {
		User = user;
	}

	@OneToMany(targetEntity=User.class,cascade=CascadeType.ALL)
	 @JoinColumn(name="role_id", referencedColumnName="id")
	private List<User> User;
	
	public Role(String name) { 
		this.name=name;
	}
	public Role() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", User=" + User + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
