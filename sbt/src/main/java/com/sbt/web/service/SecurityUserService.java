package com.sbt.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sbt.web.dto.SecurityUser;
import com.sbt.web.dto.User;

@Service
public class SecurityUserService implements UserDetailsService {
	
	private final UserService userService;
	
	@Autowired
	public SecurityUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("SecurityUserService ..................");
		User user = userService.getUserByUsername(username);
		System.out.println("userPassword >> " + user.getPassword());
		
		return new SecurityUser(user);
	}

}
