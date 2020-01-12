package com.sbt.web.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sbt.web.dto.User;

@MapperScan
public interface UserMapper {
	public List<User> getAllUser() throws Exception;
}
