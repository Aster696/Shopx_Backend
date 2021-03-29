package com.shopx.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.shopx.dao.UserDAO;
import com.shopx.mail.Email;
import com.shopx.model.User;
import com.shopx.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	public boolean addUser(User user) {
//		user.setAuthority("user");
//		user.setStatus(true);
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userDAO.addUser(user);
//		Email email = new Email(user.getEmail(), "Welcome to Shopx","Thanks for Signing in our website"); 
//		email.Sendmail();
		return true;
	}

	public boolean updateUser(User user) {
//		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		userDAO.updateUser(user);
//		Email email = new Email(user.getEmail(), "User Profile Updated", "Your user profile was updated successfully.");
//		email.Sendmail();
		return true;
	}

	public boolean deleteUser(int id) {
		userDAO.deleteUser(id);
//		Email email = new Email(user.getEmail(), "User Profile Deleted", "Good byy");
//		email.Sendmail();
		return true;
	}

	public List<User> displayUsers() {
		return userDAO.displayUsers();
	}

	public User displayUserByEmail(String email) {
		return userDAO.displayUserByEmail(email);
	}

	public User displayUserById(int id) {
		
		return userDAO.displayUserById(id);
	}

//	public User displayUserByUser(String username) {
//		
//		return userDAO.displayUserByName(username);
//	}

	public User displayUserByName(String username) {
		return userDAO.displayUserByName(username);
	}

	public List<User> searchUser(String email) {
		return userDAO.searchUser(email);
	}

	public boolean isUsernameExist(String username) {
		
		return userDAO.isUsernameExist(username);
	}

}
