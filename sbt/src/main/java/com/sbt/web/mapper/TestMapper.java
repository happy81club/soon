package com.sbt.web.mapper;

import java.util.List;

import com.sbt.web.dto.Test;

public interface TestMapper {
	public List<Test> getAll() throws Exception;
}
