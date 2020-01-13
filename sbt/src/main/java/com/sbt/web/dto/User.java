package com.sbt.web.dto;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class User {
	private  String username;
	private  String password;
	//private  String role;
	private  boolean enabled;
	
	private String encoderPassword;
	
	private Role role;
	
	
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEncoderPassword() {
		PasswordEncoder encoder =
			    PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder.encode(this.password);
	}
	
	
}
