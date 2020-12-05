package com.yzk.personnel.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzk.personnel.model.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
