package com.shopx.service;

import java.util.List;

import com.shopx.model.User;

public interface UserService {
	
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
	public List<User> displayUsers();
	public User displayUserByEmail(String email);
	public User displayUserById(int id);
	public User displayUserByName(String username);
	public List<User> searchUser(String email);
	
}
