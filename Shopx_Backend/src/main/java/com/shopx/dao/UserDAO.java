package com.shopx.dao;

import java.util.List;

import com.shopx.model.User;

public interface UserDAO {

	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int id);
	public List<User> displayUsers();
	public User displayUserByEmail(String email);
	public User displayUserById(int id);
	public User displayUserByName(String username);
	public List<User> searchUser(String email);
	public boolean isUsernameExist(String username);
}
