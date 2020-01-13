package com.sbt.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbt.web.dto.User;
import com.sbt.web.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public List<User> getAll() throws Exception{
		return userMapper.getAllUser();
	}
	
	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);
	}
}
