package com.sbt.web.dto;

import org.springframework.security.core.authority.AuthorityUtils;

public class SecurityUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = -7487718794868683010L;
	private User user;
	
	public SecurityUser(User user) {
		
		super(user.getUsername(), 
			  user.getEncoderPassword(), 
			  AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
		// TODO Auto-generated constructor stub
	}

	public User getUser() {
		return user;
	}

	
	public Role getRole() { 
		return user.getRole(); 
	}


}
