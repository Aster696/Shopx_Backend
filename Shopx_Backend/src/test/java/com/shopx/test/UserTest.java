package com.shopx.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.shopx.config.DbConfig;
import com.shopx.model.User;
import com.shopx.serviceimpl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = DbConfig.class)
public class UserTest {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@Test
	@Ignore
	public void addUser() {
		User user = new User();
		user.setUsername("raj");
		user.setEmail("raj@gmail.com");
		user.setContact("37483748");
		user.setPassword("raj");
		//user.setAuthority("user");
		//user.setStatus(true);
		
		assertEquals(true, userServiceImpl.addUser(user));
	}
	@Test
	@Ignore
	public void updateUser() {
		User user = new User();
		user.setId(2);
		user.setUsername("Alister");
		user.setEmail("alister@gmail.com");
		user.setContact("37483748");
		user.setPassword("alister");
		
		assertEquals(true, userServiceImpl.updateUser(user));
	}
	@Test
	@Ignore
	public void deleteUser() {
		assertEquals(true, userServiceImpl.deleteUser(3));
	}
	
	@Test
	@Ignore
	public void displayUsers() {
		assertNotEquals(null, userServiceImpl.displayUsers());
		
	}
	
	@Test
//	@Ignore
	public void displayUserByEmail() {
		try {
			assertNotNull(userServiceImpl.displayUserByEmail("asterrebeiro24@gmail.com"));
			System.out.println("success");
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
}
