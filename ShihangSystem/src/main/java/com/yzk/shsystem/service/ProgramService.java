package com.yzk.shsystem.service;

import org.springframework.data.domain.Page;

import com.yzk.shsystem.model.Program;

public interface ProgramService {
	Page<Program> findProgramNoCriteria(Integer page, Integer size);

	Page<Program> findProgramCriteria(Integer page, Integer size, Program bookQuery);
}
