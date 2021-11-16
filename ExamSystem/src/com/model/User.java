package com.model;

import com.dal.userDal;

public class User {
	private String username;
	private String password;
	private int role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public User(String username, String password, int role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public User() {
		
	}
	public User login(String username,String password) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		return userDal.login(user);		
	}
	public boolean updatePassword(String username,String password) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		return userDal.updatePassword(user);	
	}
}
