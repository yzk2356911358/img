package com.yzk.shsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.yzk.shsystem.model.Program;

public interface ProgramDao extends JpaRepository<Program, Integer>,JpaSpecificationExecutor<Program> {

}
