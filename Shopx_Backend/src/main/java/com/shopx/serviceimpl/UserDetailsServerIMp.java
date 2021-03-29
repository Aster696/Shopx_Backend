package com.shopx.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.shopx.model.User;
import com.shopx.service.UserService;

@Service("userDetailsService")
public class UserDetailsServerIMp implements UserDetailsService{

	@Autowired
	UserService userService;
	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user1 = userService.displayUserByEmail(email);
		UserBuilder builder = null;
		if(user1 != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(email);
			builder.disabled(!user1.isStatus());
			builder.password(user1.getPassword());
			String[] authorities = new String[] {user1.getAuthority()};
			
			builder.authorities(authorities);
		}else {
			throw new UsernameNotFoundException("user name not found... ");
		}
		
		return builder.build();
	}

}
